package com.example.studentdetails.entity;


import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="course")
public class Course {
    @Id 
    @Column(name="courseid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int courseId;
    
    @Column(name="coursename")
    String courseName;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    @OneToOne(mappedBy = "course")
    private Teacher teacher;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "course",fetch = FetchType.EAGER)
    private List<Student> student = new ArrayList<>();

     
 
   
}
