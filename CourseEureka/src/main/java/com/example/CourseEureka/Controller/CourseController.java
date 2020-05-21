package com.example.CourseEureka.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.CourseEureka.Model.Course;
import com.example.CourseEureka.Model.Student;
import com.example.CourseEureka.Service.CourseService;


@RestController
@RequestMapping("/user")
public class CourseController {

	@Autowired
	CourseService courseService;
	
	@GetMapping("/userlist")
	public String getStudentList() {
		return courseService.getStudentList();
	}
	
	@GetMapping("{userId}")
	public String getByStudentId(@PathVariable String userId){
		return courseService.getByStudentId(userId);
	}
	
	@GetMapping("user1")
	public String getStudentIdByParam(@RequestParam String userName){
		return courseService.getUserBypram(userName);
	}
	@PostMapping("/userbody")
	public ResponseEntity<String> createStudent(@RequestBody Student student){
		
		return courseService.createStudent(student);
			
	}

	@PostMapping("/course")
	public ResponseEntity<Course> createCourse(@RequestBody Course course) {
		// studentService.createStudent(student);
		return new ResponseEntity<Course>(courseService.createCourse(course), HttpStatus.OK);

	}
	
	@GetMapping("/courselist")
	public ResponseEntity<List<Course>> viewAllCourses() {

		List<Course> courses = courseService.viewAllCourses();

		return new ResponseEntity<List<Course>>(courses, HttpStatus.OK);

	}
	
	@GetMapping("/courseid/{courseId}") 
	  public ResponseEntity<Course> viewById(@PathVariable int courseId) {
	  
	  Course course = courseService.findById(courseId);
	  return new ResponseEntity<Course>(course, HttpStatus.OK);
	  
	  }
	
	@GetMapping("/courseName/{courseName}")
	  public ResponseEntity<List<Course>> viewCourseName(@PathVariable String courseName) {

			List<Course> courses = courseService.viewCourseName(courseName);

			return new ResponseEntity<List<Course>>(courses, HttpStatus.OK);

		}
	
	@PutMapping("/courses")
	public ResponseEntity<Course> updateCourse(@RequestBody Course course) {

			return new ResponseEntity<Course>(courseService.updateCourse(course), HttpStatus.OK);
		} 
	@DeleteMapping("/course/{courseId}")
	public ResponseEntity<String> deleteById(@PathVariable("courseId") int courseId) {
		
		courseService.deleteById(courseId);

			return new ResponseEntity<String>("Course  Id : " + courseId + " is deleted.", HttpStatus.OK);

		} 



}
