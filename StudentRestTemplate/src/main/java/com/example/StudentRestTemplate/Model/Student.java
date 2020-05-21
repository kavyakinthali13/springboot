package com.example.StudentRestTemplate.Model;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Student {
	
	@Id
	private int studId;

	private String studName;
	private String studAge;
	@JsonIgnoreProperties("students")
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable
	private Set<Course> courses = new HashSet<Course>();

	
	public Student(int studId, String studName, String studAge, Set<Course> courses) {
		super();
		this.studId = studId;
		this.studName = studName;
		this.studAge = studAge;
		this.courses = courses;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getStudId() {
		return studId;
	}

	public void setStudId(int studId) {
		this.studId = studId;
	}

	public String getStudName() {
		return studName;
	}

	public void setStudName(String studName) {
		this.studName = studName;
	}

	public String getStudAge() {
		return studAge;
	}

	public void setStudAge(String studAge) {
		this.studAge = studAge;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}



}
