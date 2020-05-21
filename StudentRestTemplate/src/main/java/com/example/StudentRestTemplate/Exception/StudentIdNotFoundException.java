package com.example.StudentRestTemplate.Exception;

public class StudentIdNotFoundException extends RuntimeException{
	
	public StudentIdNotFoundException() {
		super("Student Id not found");
	}

}
