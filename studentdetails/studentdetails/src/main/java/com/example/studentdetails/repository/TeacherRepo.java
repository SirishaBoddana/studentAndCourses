package com.example.studentdetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.studentdetails.entity.Teacher;
@Repository
public interface TeacherRepo extends JpaRepository<Teacher,Integer>{
    
}
