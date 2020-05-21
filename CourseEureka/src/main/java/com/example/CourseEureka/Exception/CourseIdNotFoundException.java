package com.example.CourseEureka.Exception;

public class CourseIdNotFoundException  extends RuntimeException{
	
	public CourseIdNotFoundException() {

        super("Course Id not  found");
    }
}
