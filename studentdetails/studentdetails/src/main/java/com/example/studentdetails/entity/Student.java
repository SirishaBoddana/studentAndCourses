package com.example.studentdetails.entity;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "students")
public class Student {
    @Id
    @Column(name = "studentid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(name = "studentname")
    private String studentName;
    @Column(name = "DOB")
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date dob;
    @Column(name = "mobile")
    @Digits(integer = 10, fraction = 0)
    private long mobile; 


    @ManyToOne
    @JoinColumn(name="courseid")
    private Course course;
    
    // @ManyToMany
    // @JoinTable(name = "student_column", 
    // joinColumns = @JoinColumn(name = "Id", referencedColumnName = "Id"), 
    // inverseJoinColumns = @JoinColumn(name = "columnId"))
    // private Set<Course> courses = new HashSet<Course>();



}
