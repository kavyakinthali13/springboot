package com.example.CourseEureka.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.CourseEureka.Exception.CourseIdNotFoundException;
import com.example.CourseEureka.Exception.CourseNameNotFoundException;
import com.example.CourseEureka.Exception.NoCourseFoundException;
import com.example.CourseEureka.Exception.StudentIdNotFoundException;
import com.example.CourseEureka.Model.Course;
import com.example.CourseEureka.Model.Student;
import com.example.CourseEureka.Repository.CourseRepository;


@Service
public class CourseService {
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	public String getStudentList() {
		String result = restTemplate.getForObject("http://STUDENT-SERVICE/studentlist", String.class);
		return result;
	}
	
	@Bean
	@LoadBalanced
	RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	public String getByStudentId(String userId) {
		try {
		String url = "http://STUDENT-SERVICE/studentid/" + userId;
		String result = restTemplate.getForObject(url, String.class);
		return result;
		}
		catch(Exception e) {
			 throw new StudentIdNotFoundException();
		}


	}

	public String getUserBypram(String userName) {
		String url = "http://STUDENT-SERVICE/studentName/" + userName;

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		Map<String, String> params = new HashMap<String, String>();
		params.put("userName", userName);

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
		for (Map.Entry<String, String> entry : params.entrySet()) {
			builder.queryParam(entry.getKey(), entry.getValue());
		}

		String result = restTemplate.getForObject(builder.toUriString(), String.class);
		return result;

	}

	public ResponseEntity<String> createStudent(Student student) {
		String uri = "http://STUDENT-SERVICE/student";

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		JSONObject request = new JSONObject();
		request.put("studId", student.getStudId());
		request.put("studName", student.getStudName());
		request.put("studAge", student.getStudAge());
		request.put("courses", student.getCourses());

		HttpEntity<String> entity = new HttpEntity<String>(request.toString(), headers);

		ResponseEntity<String> response = restTemplate.postForEntity(uri, entity, String.class);

		System.out.println(response);
		return response;
	
	}

	
	public Course createCourse(Course course) {
		 
		return courseRepository.save(course);
		
	}

	
	public List<Course> viewAllCourses() {
		List<Course> courses = courseRepository.findAll();
		 if(courses.isEmpty()) {
			 throw new NoCourseFoundException();
		 } else
		 {
			 return courses;
		 }
	}

	
	public Course findById(int courseId) {
		
		Optional<Course> course = courseRepository.findById(courseId);
		if(course.isPresent()) {
			return course.get();
		} else
		{
			throw new CourseIdNotFoundException();
		}
	}

	
	public List<Course> viewCourseName(String courseName) {
		List<Course> course = courseRepository.findByCourseName(courseName);
		if(course.isEmpty()) {
			return course;
		} else
		{
			throw new CourseNameNotFoundException();
		}
		
	}

	
	public Course updateCourse(Course course) {
		// TODO Auto-generated method stub
		return courseRepository.save(course);
	}

	public void deleteById(int courseId) {
		// TODO Auto-generated method stub
		courseRepository.deleteById(courseId);

	}

}
