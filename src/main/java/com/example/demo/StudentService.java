package com.example.demo;

public class StudentService {

	void saveStudentInDb(Student s) {
		
		System.out.println("Student admission done for student:" +s.getName());
	}

	public void deleteStudentFromDb(Student s) {

		System.out.println("Student deleted:" +s.getName());

	}
}
