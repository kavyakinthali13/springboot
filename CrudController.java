package com.hcl.CRUD.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.CRUD.Model.Student;
import com.hcl.CRUD.Service.CrudService;

@RestController
public class CrudController {
	
	@Autowired
	CrudService crudService;
	
	@PostMapping("/savestudent")  
	private Student saveStudent(@RequestBody Student student)   
	{  
	crudService.save(student);  
	//return student.getBookid();  
	return student;
	}  
	
	
	@GetMapping("/getstudent")
	public List<Student> getAllDetails()   
	{  
	return crudService.findAll(); 
	}  
	
	@GetMapping("/getstudent/{stuId}")  
	private Student getStudent(@PathVariable("stuId") int stuId)   
	{  
	return crudService.getStudentById(stuId);  
	} 
	
	@PutMapping("/updatestudent")  
	private Student update(@RequestBody Student student)   
	{  
	crudService.saveOrUpdate(student);  
	return student;
	  
	}  
	
	@DeleteMapping("/delete/{stuId}")  
	private void deleteStudent(@PathVariable("stuId") int stuId)   
	{  
	crudService.delete(stuId);  
	}  

}
