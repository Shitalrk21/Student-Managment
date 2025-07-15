package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import com.example.demo.entity.Student;

public interface StudentServiceRepo extends JpaRepository<Student, Integer>{

}
