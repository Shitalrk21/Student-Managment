package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import com.example.demo.service.StudentServiceImpl;

@RestController
public class StudentController {

	@Autowired
	StudentService ss;
	//StudentService ss = new StudentServiceImpl();
	@PostMapping("addStudent")
	public String addStudent(@RequestBody Student student) {
		
		ss.saveStudent(student);
		return "Student added";
		
	}
}
