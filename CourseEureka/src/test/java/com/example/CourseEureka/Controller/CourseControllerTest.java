package com.example.CourseEureka.Controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.CourseEureka.Model.Course;
import com.example.CourseEureka.Model.Student;
import com.example.CourseEureka.Service.CourseService;

import junit.framework.Assert;



@RunWith(MockitoJUnitRunner.Silent.class)
public class CourseControllerTest {
	
	@InjectMocks
	CourseController courseController;
	
	@Mock
	CourseService courseService;
	
	@Test
	public void testCreateCourse() {
		Course course = new Course();
		course.setCourseId(1);
		course.setCourseName("java");
		course.setAbout("programming");
		Set<Student> students = new HashSet<Student>();
		Student student = new Student();
		student.setStudId(2);
		student.setStudName("kavi");
		student.setStudAge("22");
		students.add(student);
		course.setStudents(students);
	

		courseController.createCourse(course);
		Mockito.verify(courseService, Mockito.times(1)).createCourse(course);

	}

	@Test
	public void testViewAllcourses() {

		List<Course> courses = new ArrayList(); 

		Course course = new Course();
		course.setCourseId(3);
		course.setCourseName("oracle");
		course.setAbout("database");
		Set<Student> students = new HashSet<Student>();
		Student student = new Student();
		student.setStudId(2);
		student.setStudName("kavi");
		student.setStudAge("22");
		students.add(student);
		course.setStudents(students);
		courses.add(course);

		course = new Course();
		course.setCourseId(4);
		course.setCourseName("java");
		course.setAbout("programming");
		 students = new HashSet<Student>();
		student = new Student();
		student.setStudId(2);
		student.setStudName("kavi");
		student.setStudAge("22");
		students.add(student);
		course.setStudents(students);
		courses.add(course);

		Mockito.when(courseService.viewAllCourses()).thenReturn(courses);

		ResponseEntity<List<Course>> courses2 = courseController.viewAllCourses();
		Assert.assertNotNull(courses2);
		Assert.assertEquals(HttpStatus.OK, courses2.getStatusCode());
	}

	@Test
	public void testViewById() {

		Course course = new Course();
		course.setCourseId(4);
		course.setCourseName("java");
		course.setAbout("programming");
		Set<Student> students = new HashSet<Student>();
		Student student = new Student();
		student.setStudId(2);
		student.setStudName("kavi");
		student.setStudAge("22");
		students.add(student);
		course.setStudents(students);

		Mockito.when(courseService.findById(4)).thenReturn(course);

		ResponseEntity<Course> courses2 = courseController.viewById(4);
		Assert.assertNotNull(courses2);
		Assert.assertEquals(4, 4);
	}
	
	@Test(expected = Exception.class)
	public void testViewByIdForExce() {
		Course course = new Course();
		course.setCourseId(4);
		Mockito.when(courseService.findById(3)).thenThrow(Exception.class);
		ResponseEntity<Course> resCourse = courseController.viewById(3);
		Assert.assertNotNull(resCourse);
		Assert.assertEquals(3, 2);
	}


	@Test
	public void testViewCourseName() {
		List<Course> courses = new ArrayList();
		Course course = new Course();
		course.setCourseId(4);
		course.setCourseName("java");
		Set<Student> students = new HashSet<Student>();
		Student student = new Student();
		student.setStudId(2);
		student.setStudName("kavi");
		student.setStudAge("22");
		students.add(student);
		course.setStudents(students);
		courses.add(course);

		Mockito.when(courseService.viewCourseName("java")).thenReturn(courses);

		ResponseEntity<List<Course>> courses2 = courseController.viewCourseName("java");
		Assert.assertNotNull(courses2);
		Assert.assertEquals(HttpStatus.OK, courses2.getStatusCode());
	}
	
	@Test
	public void testUpdatecourse() {
		Course course = new Course();
		course.setCourseId(1);
		course.setCourseName("java");
		course.setAbout("programming");
		Set<Student> students = new HashSet<Student>();
		Student student = new Student();
		student.setStudId(2);
		student.setStudName("kavi");
		student.setStudAge("22");
		students.add(student);
		course.setStudents(students);
		
		courseController.updateCourse(course);
		Mockito.verify(courseService, Mockito.times(1)).updateCourse(course);
	
}


}
