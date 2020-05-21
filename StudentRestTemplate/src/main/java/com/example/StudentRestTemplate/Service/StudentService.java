package com.example.StudentRestTemplate.Service;

import java.util.List;

import com.example.StudentRestTemplate.Model.Student;

public interface StudentService {
	Student createStudent(Student student);

	List<Student> viewAllStudents();

	Student updateStudent(Student student);

	void deleteById(int studId);

	Student findById(int studId);

	

	List<Student> viewStudName(String studName);

}
