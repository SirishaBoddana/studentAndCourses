package com.example.studentdetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.studentdetails.entity.Course;

@Repository
public interface CourseRepo extends JpaRepository<Course,Integer>{
    
}
