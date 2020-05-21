package com.example.StudentRestTemplate.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.StudentRestTemplate.Exception.NoStudentFoundException;
import com.example.StudentRestTemplate.Exception.StudentIdNotFoundException;
import com.example.StudentRestTemplate.Exception.StudentNameNotFoundException;
import com.example.StudentRestTemplate.Model.Student;
import com.example.StudentRestTemplate.Repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentRepository studentRepository;

	@Override
	public Student createStudent(Student student) {

		return studentRepository.save(student);

	}

	public List<Student> viewAllStudents() {

		List<Student> students = studentRepository.findAll();
		if (students.isEmpty()) {
			throw new NoStudentFoundException();

		} else {
			return students;
		}
	}

	@Override
	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}

	@Override
	public void deleteById(int studId) {
		studentRepository.deleteById(studId);

	}

	@Override
	public Student findById(int studId) {
		Optional<Student> student = studentRepository.findById(studId);

		if (student.isPresent()) {
			return student.get();
		} else {
			throw new StudentIdNotFoundException();
		}
	}

	@Override
	public List<Student> viewStudName(String studName) {
		List<Student> student =  studentRepository.findByStudName(studName);
		if(student != null) {
			return student;
		}else 
		{
			throw new StudentNameNotFoundException();
		}
		
	}

}
