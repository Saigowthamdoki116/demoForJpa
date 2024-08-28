package com.example.demoForJpa.service;

import com.example.demoForJpa.dto.SaveStudentRequest;
import com.example.demoForJpa.entity.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IStudentService {
    Student saveStudent(SaveStudentRequest saveStudentRequest);
    List<Student> getStudents();
    ResponseEntity<Student> getStudent(@PathVariable long id);
    ResponseEntity<Student> updateStudents(@PathVariable long id, @RequestBody Student stud);
    ResponseEntity<Void> deleteStudent(@PathVariable long id);
}
