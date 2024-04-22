package com.example.studentdetails.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.studentdetails.entity.Student;
import com.example.studentdetails.exceptions.StudentNotFoundException;
import com.example.studentdetails.repository.StudentRepo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class StudentService  {
    @Autowired
    StudentRepo studentRepo;
    

     Logger logger = LoggerFactory.getLogger(StudentService.class);

    //GetMethod(All Students)
    public List<Student> getAllStudents() {
        logger.info("List of all Students");
        List<Student> stud = studentRepo.findAll();
        if (!stud.isEmpty())
            return stud;
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "List is Empty");
            }
    }
    //GetMethod(Students by Id)
    public Optional<Student> getStudentById(int Id) {
            logger.info("Student Id", Id);
            Optional<Student> stud = studentRepo.findById(Id);
            if (stud.isPresent()) {
                return stud;
            } else {
                throw new StudentNotFoundException();
            }
    }


    //PostMethod
    public Student saveStudent(Student student) {
        logger.info("Student was added to the list");
        return studentRepo.save(student);
    }
    
    public List<Student> saveStudents(List<Student> students) {
        logger.info("All Student was added to the list");
        return studentRepo.saveAll(students);
    }
    
   //DeleteMethod
    public void deleteById(int Id) {
            var stud = studentRepo.findById(Id);
            logger.info("Student deleted!!!");
            if (stud.isPresent()) {
                studentRepo.deleteById(Id);
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "StudentId Not Found");
            }
    }
    //PutMethod
    public Student updateStudent(Student student) {
    Student existingStudent = studentRepo.findById(student.getId()).orElse(student);
    logger.info("Student Id was updating");
    existingStudent.setStudentName(student.getStudentName());
    existingStudent.setDob(student.getDob());
    existingStudent.setMobile(student.getMobile());
    return studentRepo.save(existingStudent);
    }

}




