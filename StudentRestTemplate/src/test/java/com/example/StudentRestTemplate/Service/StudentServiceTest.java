package com.example.StudentRestTemplate.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.StudentRestTemplate.Exception.NoStudentFoundException;
import com.example.StudentRestTemplate.Exception.StudentIdNotFoundException;
import com.example.StudentRestTemplate.Model.Course;
import com.example.StudentRestTemplate.Model.Student;
import com.example.StudentRestTemplate.Repository.StudentRepository;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.Silent.class)
public class StudentServiceTest {

	@InjectMocks
	StudentServiceImpl studentServiceImpl;

	@Mock
	StudentRepository studentRepository;
	
	static Student student = null;


	
	@BeforeClass
	public static void setup() {

		student = new Student();
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
	
		
	}


	@Test
	public void testCreateStudent() {

		Mockito.when(studentRepository.save(student)).thenReturn(student);
		Student student1 = studentServiceImpl.createStudent(student);
		Assert.assertNotNull(student1);
		Assert.assertEquals(student.getStudId(), student1.getStudId());

	}
	
	@Test
	public void testViewAllStudents() {
		List<Student> students = new ArrayList<>();
		Student student = new Student();
		student.setStudId(2);
		student.setStudName("kiran");
		student.setStudAge("20");
		Set<Course> courses = new HashSet<Course>();
		Course course = new Course();
		course.setCourseId(2);
		course.setCourseName("java");
		course.setAbout("programming");
		courses.add(course);
		student.setCourses(courses);
	
		students.add(student);
		
		
		Mockito.when(studentRepository.findAll()).thenReturn(students);
		
		List<Student> students2 = studentServiceImpl.viewAllStudents();
		Assert.assertNotNull(students2);
		Assert.assertEquals(students, students2);
		
	}
	
	@Test(expected = NoStudentFoundException.class)
	public void testGetAllStudentsForExc() {
		Mockito.when(studentRepository.findAll()).thenThrow(NoStudentFoundException.class);
		List<Student> resStudents = studentServiceImpl.viewAllStudents();

	}


	@Test
	public void testViewByIdForPositive() {
		Mockito.when(studentRepository.findById(student.getStudId())).thenReturn(Optional.of(student));

		Student student1 = studentServiceImpl.findById(student.getStudId());
		Assert.assertNotNull(student1);
		Assert.assertEquals(student, student1);

	}
	
	@Test(expected = StudentIdNotFoundException.class)
	public void testViewByIdForExce() {
		Student student = new Student();
		student.setStudId(2);
		student.setStudName("kavya");
		Mockito.when(studentRepository.findById(2)).thenReturn(Optional.of(student));
		Student resStudent = studentServiceImpl.findById(1);
	}

	
	@Test
	public void testViewStudNameForPositive() {
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

		Mockito.when(studentRepository.findByStudName("madhav")).thenReturn(students);

		List<Student> students2 = studentServiceImpl.viewStudName("madhav");
		Assert.assertNotNull(students2);
		Assert.assertEquals(1,students2.size());

	}

	@Test
	public void testDeleteById(){
		Student student = new Student();
		student.setStudId(3);
		student.setStudName("kavya");
		student.setStudAge("22");
		Set<Course> courses = new HashSet<Course>();
		Course course = new Course();
		course.setCourseId(2);
		course.setCourseName("java");
		course.setAbout("programming");
		courses.add(course);
		student.setCourses(courses);
	
		studentServiceImpl.deleteById(3);
        Mockito.verify(studentRepository, Mockito.times(1)).deleteById(3);
	}

	@Test
	public void testUpdateStudent() {

		Mockito.when(studentRepository.save(student)).thenReturn(student);
		Student student1 = studentServiceImpl.updateStudent(student);
		Assert.assertNotNull(student1);
		Assert.assertEquals(student.getStudId(), student1.getStudId());

	}



}
