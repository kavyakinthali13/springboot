package com.example.StudentRestTemplate.Exception;

public class StudentNameNotFoundException extends RuntimeException {
	
	public StudentNameNotFoundException() {
		super("student Name not found");
	}

}
