package com.example.CourseEureka.Exception;

public class NoCourseFoundException extends RuntimeException {
	
	public NoCourseFoundException() {
		super("No Course found");
	}

}
