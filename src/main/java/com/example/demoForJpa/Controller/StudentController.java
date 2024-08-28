package com.example.demoForJpa.Controller;

import com.example.demoForJpa.dto.SaveStudentRequest;
import com.example.demoForJpa.entity.Student;
import com.example.demoForJpa.repo.StudentRepo;
import com.example.demoForJpa.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentRepo studentRepo;

    @Autowired
    IStudentService iStudentService;
    @PostMapping("/api/students")
    public ResponseEntity<Student> saveStudent(@RequestBody SaveStudentRequest saveStudentRequest){
        Student student = iStudentService.saveStudent(saveStudentRequest);
        System.out.println(student);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }
    @GetMapping("/api/students")
    public ResponseEntity<List<Student>> getStudents(){
        return new ResponseEntity<>(iStudentService.getStudents(), HttpStatus.OK);
    }
    @GetMapping("/api/students/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable long id){
       return iStudentService.getStudent(id);

    }
    @PutMapping("/api/students/{id}")
    public ResponseEntity<Student> updateStudents(@PathVariable long id,@RequestBody Student stud){
        return iStudentService.updateStudents(id,stud);
    }
    @DeleteMapping("/api/students/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable long id){
        return iStudentService.deleteStudent(id);

    }
}
