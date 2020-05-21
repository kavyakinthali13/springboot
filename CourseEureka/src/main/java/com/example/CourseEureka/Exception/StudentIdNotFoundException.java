package com.example.CourseEureka.Exception;

public class StudentIdNotFoundException extends RuntimeException{
	
	public StudentIdNotFoundException() {
		super("Student Id not found");
	}

}
