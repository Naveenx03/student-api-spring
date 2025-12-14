package com.students.studentapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.students.studentapi.model.Students;
import com.students.studentapi.service.StudentsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/students")
public class StudentsController {

    @Autowired
    private StudentsService service;

    @GetMapping
    public List<Students> Students(){
        return service.getStudents();
    }

    @GetMapping("/{id}")
    public Students student(@PathVariable int id){
        return service.getStudent(id);
    }

    @PostMapping
    public Students create(@Valid @RequestBody Students student){
        return service.addStudent(student);
    }

    @PutMapping("{id}")
    public Students update(@Valid @RequestBody Students student, @PathVariable int id){
        return service.updateStudent(student, id);
    }

    @DeleteMapping
    public String delete(){
        return service.deleteStudents();
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable int id){
        return service.deleteStudentById(id);
    }

}
