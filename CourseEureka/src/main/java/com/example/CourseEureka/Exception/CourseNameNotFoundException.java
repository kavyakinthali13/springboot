package com.example.CourseEureka.Exception;

public class CourseNameNotFoundException extends RuntimeException {
	
	public  CourseNameNotFoundException() {
		super("Course Name Not Found");
	}

}
