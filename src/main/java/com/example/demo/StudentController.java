package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class StudentController {

	StudentService ss= new StudentService();

	@PostMapping("student/addStudent")
	 String addStudent(@RequestBody Student s) {
		ss.saveStudentInDb(s);
		return "student admission is done, name = "+s.getName();
	}
	
	@DeleteMapping("student/deleteStudent")
	String deleteStudent(@RequestBody Student s) {
		ss.deleteStudentFromDb(s);
		
		System.out.println("just cheking code");
		return "student deleted";
		
	}
	
}


