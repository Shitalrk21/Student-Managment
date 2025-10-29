package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentServiceRepo;

@Service
public class StudentServiceImpl  implements StudentService{

	@Autowired
	StudentServiceRepo sr;
	
	@Override
	public void saveStudent(Student student) {
    sr.save(student);	
	}

}
