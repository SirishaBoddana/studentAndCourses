package com.example.studentdetails.controller;


import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.example.studentdetails.entity.Student;
import com.example.studentdetails.service.StudentService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    StudentService service;
    Logger logger=LoggerFactory.getLogger(StudentController.class);

    @GetMapping("")
    public ResponseEntity<?> getStudents() {
        List<Student> stud = service.getAllStudents();
        HttpStatus status = !stud.isEmpty() ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return ResponseEntity.status(status).body(stud);
    }

    @GetMapping("/{Id}")
    public ResponseEntity<?> getStudentById(@PathVariable int Id) {
        Optional<Student> stud = service.getStudentById(Id);
        HttpStatus status = stud.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return ResponseEntity.status(status).body(stud);
    }

    @PostMapping("")
    public ResponseEntity<?> saveStudent(@RequestBody Student stud) {
            service.saveStudent(stud);
            return ResponseEntity.ok("Student added to the List") ;
    } 
    

    @PutMapping("/{Id}")
    public ResponseEntity<?> updateStudent(@PathVariable Student Id) {
        service.updateStudent(Id);
        return ResponseEntity.ok("Updated!!!");
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<?> deleteById(@PathVariable int Id) {
        service.deleteById(Id);
        return ResponseEntity.ok("Student deleted");
    }

 }

