package com.example.StudentRestTemplate.Exception;

public class NoStudentFoundException extends RuntimeException {
	
	public NoStudentFoundException() {
		super("Stundent not saved");
	}

}
