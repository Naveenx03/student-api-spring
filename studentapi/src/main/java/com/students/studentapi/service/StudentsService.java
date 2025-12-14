package com.students.studentapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.students.studentapi.repository.StudentsRepository;
import com.students.studentapi.exception.StudentNotFoundException;
import com.students.studentapi.model.Students;

@Service
public class StudentsService {

    @Autowired
    private StudentsRepository repo;

    public Students addStudent(Students s){
        return repo.save(s);
    }

    public List<Students> getStudents(){
        return repo.findAll();
    }

    public Students getStudent(int id){
        return repo.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not found with ID: "+id));
    }

    public Students updateStudent(Students s, int id){

        if(!repo.existsById(id)) throw new StudentNotFoundException("No student exist with ID: "+id);

        Students student = getStudent(id);
        student.setName(s.getName());
        student.setAge(s.getAge());
        student.setEmail(s.getEmail());
        
        return repo.save(student);
    }

    public String deleteStudentById(int id){

        if(!repo.existsById(id)) throw new StudentNotFoundException("No student exist with ID: "+id);
        repo.deleteById(id);
        return "Student with ID: "+id+" deleted";
    }

    public String deleteStudents(){
        repo.deleteAll();
        return "Student records deleted";
    }
    


}
