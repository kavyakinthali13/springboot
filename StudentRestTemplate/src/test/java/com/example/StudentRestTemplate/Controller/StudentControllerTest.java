package com.example.StudentRestTemplate.Controller;

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

import com.example.StudentRestTemplate.Service.StudentService;
import com.example.StudentRestTemplate.Model.Course;
import com.example.StudentRestTemplate.Model.Student;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.Silent.class)
public class StudentControllerTest {
	@InjectMocks
	StudentController studentController;

	@Mock
	StudentService studentService;

	@Test
	public void testCreateStudent() {
		Student student = new Student();
		student.setStudId(1);
		student.setStudName("kavya");
		student.setStudAge("22");
		Set<Course> courses = new HashSet<Course>();
		Course course = new Course();
		course.setCourseId(2);
		course.setCourseName("java");
		course.setAbout("programming");
		courses.add(course);
		student.setCourses(courses);
	

		studentController.createStudent(student);
		Mockito.verify(studentService, Mockito.times(1)).createStudent(student);

	}

	@Test
	public void testViewAllStudents() {

		List<Student> students = new ArrayList();

		Student student = new Student();
		student.setStudId(3);
		student.setStudName("madhav");
		student.setStudAge("25");
		Set<Course> courses = new HashSet<Course>();
		Course course = new Course();
		course.setCourseId(2);
		course.setCourseName("java");
		course.setAbout("programming");
		courses.add(course);
		student.setCourses(courses);
		students.add(student);


		Mockito.when(studentService.viewAllStudents()).thenReturn(students);

		ResponseEntity<List<Student>> students2 = studentController.viewAllStudents();
		Assert.assertNotNull(students2);
		Assert.assertEquals(HttpStatus.OK, students2.getStatusCode());
	}
	@Test(expected = Exception.class)
	public void testGetAllStudentsForExc() {
		Mockito.when(studentService.viewAllStudents()).thenThrow(Exception.class);
		List<Student> resStudents = (List<Student>) studentController.viewAllStudents();

	}



	@Test
	public void testViewById() {

		Student student = new Student();
		student.setStudId(3);
		student.setStudName("madhav");
		student.setStudAge("22");
		Set<Course> courses = new HashSet<Course>();
		Course course = new Course();
		course.setCourseId(2);
		course.setCourseName("java");
		course.setAbout("programming");
		courses.add(course);
		student.setCourses(courses);
	

		Mockito.when(studentService.findById(3)).thenReturn(student);

		ResponseEntity<Student> students2 = studentController.viewById(3);
		Assert.assertNotNull(students2);
		Assert.assertEquals(3, 3);
	}
	@Test
	public void testViewStudName() {
		List<Student> students = new ArrayList();
		Student student = new Student();
		student.setStudId(3);
		student.setStudName("madhav");
		Set<Course> courses = new HashSet<Course>();
		Course course = new Course();
		course.setCourseId(2);
		course.setCourseName("java");
		course.setAbout("programming");
		courses.add(course);
		student.setCourses(courses);
	
		students.add(student);

		Mockito.when(studentService.viewStudName("madhav")).thenReturn(students);

		ResponseEntity<List<Student>> students2 = studentController.viewStudName("madhav");
		Assert.assertNotNull(students2);
		Assert.assertEquals(HttpStatus.OK, students2.getStatusCode());
	}
	
	@Test
	public void testUpdateStudent() {
		Student student = new Student();
		student.setStudId(1);
		student.setStudName("kavya");
		student.setStudAge("22");
		Set<Course> courses = new HashSet<Course>();
		Course course = new Course();
		course.setCourseId(2);
		course.setCourseName("java");
		course.setAbout("programming");
		courses.add(course);
		student.setCourses(courses);
	
		
		studentController.updateStudent(student);
		Mockito.verify(studentService, Mockito.times(1)).updateStudent(student);
	
}


}
