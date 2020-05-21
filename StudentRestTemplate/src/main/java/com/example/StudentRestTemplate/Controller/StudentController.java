package com.example.StudentRestTemplate.Controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.StudentRestTemplate.Model.Student;
import com.example.StudentRestTemplate.Service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;

	@PostMapping("/student")
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
		student = studentService.createStudent(student);
		return new ResponseEntity<Student>(student, HttpStatus.OK);

	}

	@GetMapping("/studentlist")
	public ResponseEntity<List<Student>> viewAllStudents() {

		List<Student> students = studentService.viewAllStudents();

		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);

	}
	
	
	  @GetMapping("/studentid/{studId}") 
	  public ResponseEntity<Student>  viewById(@PathVariable int studId) {
	  
	  Student student = studentService.findById(studId);
	return new ResponseEntity<Student>(student, HttpStatus.OK);
	 
	  }
	  
	  @GetMapping("/studentName/{studName}")
	  public ResponseEntity<List<Student>> viewStudName(@PathVariable String studName) {

			List<Student> students = studentService.viewStudName(studName);

			return new ResponseEntity<List<Student>>(students, HttpStatus.OK);

		}
	 
	
	@PutMapping("/students")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student) {

			return new ResponseEntity<Student>(studentService.updateStudent(student), HttpStatus.OK);
		} 
	@DeleteMapping("/student/{studId}")
	public ResponseEntity<String> deleteById(@PathVariable("studId") int studId) {
		
		studentService.deleteById(studId);

			return new ResponseEntity<String>("Student Id : " + studId + " is deleted.", HttpStatus.OK);

		}


}