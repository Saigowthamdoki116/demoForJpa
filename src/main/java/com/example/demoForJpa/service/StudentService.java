package com.example.demoForJpa.service;

import com.example.demoForJpa.dto.SaveStudentRequest;
import com.example.demoForJpa.entity.Student;
import com.example.demoForJpa.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService{
    @Autowired
    StudentRepo studentRepo;
    @Override
    public Student saveStudent(SaveStudentRequest saveStudentRequest){
        Student student = new Student();
        student.setStudentName(saveStudentRequest.getStudentName());
        student.setStudentEmail(saveStudentRequest.getStudentEmail());
        student.setStudentAddress(saveStudentRequest.getStudentAddress());
        return studentRepo.save(student);
    }
    public List<Student> getStudents(){
        return studentRepo.findAll();
    }

    @Override
    public ResponseEntity<Student> getStudent(long id) {
        Optional<Student> student=studentRepo.findById(id);
        if(student.isPresent()){
            return new ResponseEntity<>(student.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<Student> updateStudents(@PathVariable long id, @RequestBody Student stud){
        Optional<Student> student=studentRepo.findById(id);
        if(student.isPresent()){
            student.get().setStudentName(stud.getStudentName());
            student.get().setStudentEmail(stud.getStudentEmail());
            student.get().setStudentAddress(stud.getStudentAddress());
            return new ResponseEntity<>(studentRepo.save(student.get()), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    public ResponseEntity<Void> deleteStudent(@PathVariable long id){
        Optional<Student> student=studentRepo.findById(id);
        if(student.isPresent()){
            studentRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }
}
