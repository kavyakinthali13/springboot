package com.example.CourseEureka.Service;

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
import org.springframework.http.ResponseEntity;

import com.example.CourseEureka.Exception.CourseIdNotFoundException;
import com.example.CourseEureka.Exception.NoCourseFoundException;
import com.example.CourseEureka.Model.Course;
import com.example.CourseEureka.Model.Student;
import com.example.CourseEureka.Repository.CourseRepository;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.Silent.class)
public class CourseServiceTest {

	@InjectMocks
	CourseService courseService;

	@Mock
	CourseRepository courseRepository;

	static Course course = null;

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

		Mockito.when(courseRepository.save(course)).thenReturn(course);
		Course course1 = courseService.createCourse(course);
		Assert.assertNotNull(course1);
		Assert.assertEquals(course.getCourseId(), course1.getCourseId());

	}

	@Test
	public void testViewAllCourses() {
		List<Course> courses = new ArrayList<>();
		Course course = new Course();
		course.setCourseId(2);
		course.setCourseName("oracle");
		course.setAbout("data abse");
		Set<Student> students = new HashSet<Student>();
		Student student = new Student();
		student.setStudId(2);
		student.setStudName("kavi");
		student.setStudAge("22");
		students.add(student);
		course.setStudents(students);
		courses.add(course);

		Mockito.when(courseRepository.findAll()).thenReturn(courses);

		List<Course> courses2 = courseService.viewAllCourses();
		Assert.assertNotNull(courses2);
		Assert.assertEquals(courses, courses2);

	}

	@Test
	public void testViewByIdForPositive() {
		Course course = new Course();
		course.setCourseId(3);
		course.setCourseName("hibernate");
		course.setAbout("ORM");
		Set<Student> students = new HashSet<Student>();
		Student student = new Student();
		student.setStudId(2);
		student.setStudName("kavi");
		student.setStudAge("22");
		students.add(student);
		course.setStudents(students);

		Mockito.when(courseRepository.findById(3)).thenReturn(Optional.of(course));

		Course course2 = courseService.findById(3);
		Assert.assertNotNull(course2);
		Assert.assertEquals(3, 3);

	}
	@Test(expected = NoCourseFoundException.class)
	public void testViewAllCoursesForExc() {
		Mockito.when(courseRepository.findAll()).thenThrow(NoCourseFoundException.class);
		List<Course> resCourses = courseService.viewAllCourses();
	}

	
	@Test(expected = CourseIdNotFoundException.class)
	public void testFindByIdForExce() {
		Course course = new Course();
		course.setCourseId(2);
		Mockito.when(courseRepository.findById(2)).thenReturn(Optional.of(course));
		Course resCourse = courseService.findById(1);
	}


	@Test
	public void testViewCourseNameForPositive() {
		List<Course> courses = new ArrayList();
		Course course = new Course();
		course.setCourseId(3);
		course.setCourseName("spring");
		Set<Student> students = new HashSet<Student>();
		Student student = new Student();
		student.setStudId(2);
		student.setStudName("kavi");
		student.setStudAge("22");
		students.add(student);
		course.setStudents(students);
		courses.add(course);

		Mockito.when(courseRepository.findByCourseName("spring")).thenReturn(courses);

		List<Course> courses2 = courseService.viewCourseName("spring");
		Assert.assertNotNull(courses2);
		Assert.assertEquals(1, courses2.size());

	}

	@Test
	public void testDeleteById() {
		Course course = new Course();
		course.setCourseId(3);
		course.setCourseName("spring");
		course.setAbout("framework");
		Set<Student> students = new HashSet<Student>();
		Student student = new Student();
		student.setStudId(2);
		student.setStudName("kavi");
		student.setStudAge("22");
		students.add(student);
		course.setStudents(students);
		courseService.deleteById(3);
		Mockito.verify(courseRepository, Mockito.times(1)).deleteById(3);
	}

	@Test
	public void testUpdateCourse() {
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

		Mockito.when(courseRepository.save(course)).thenReturn(course);
		Course course1 = courseService.updateCourse(course);
		Assert.assertNotNull(course1);
		Assert.assertEquals(course.getCourseId(), course1.getCourseId());

	}

}
