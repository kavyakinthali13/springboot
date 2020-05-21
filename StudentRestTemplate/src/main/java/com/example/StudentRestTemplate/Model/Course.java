package com.example.StudentRestTemplate.Model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class Course implements Serializable {
	@Id
	private int courseId;

	private String courseName;
	private String about;
	@JsonIgnoreProperties("courses")
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "courses", cascade = CascadeType.ALL)
	private Set<Student> students = new HashSet<Student>();

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getCourseId() {
		return courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Course(int courseId, String courseName,String about, Set<Student> students) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.about = about;
		this.students = students;
	}

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

}
