package com.example.studentdetails.entity;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class StudentCourse {

    @Column(name="student_id")
    int Id;
    @Column(name="course_id")
    int courseId; 

}