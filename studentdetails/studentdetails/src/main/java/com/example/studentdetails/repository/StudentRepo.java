package com.example.studentdetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.studentdetails.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
   
}
