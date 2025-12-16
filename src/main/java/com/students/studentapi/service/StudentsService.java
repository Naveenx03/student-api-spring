package com.students.studentapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.students.studentapi.repository.StudentsRepository;
import com.students.studentapi.dto.StudentsRequestDto;
import com.students.studentapi.dto.StudentsResponseDto;
import com.students.studentapi.exception.StudentNotFoundException;
import com.students.studentapi.model.Students;

@Service
public class StudentsService {

    @Autowired
    private StudentsRepository repo;

    public StudentsResponseDto addStudent(StudentsRequestDto s){
        Students student = new Students();
        student.setName(s.getName());
        student.setAge(s.getAge());
        student.setEmail(s.getEmail());
        repo.save(student);
        return mapToResponseDto(student);
    }

    public List<StudentsResponseDto> getStudents(){
        return repo.findAll().stream().map(this::mapToResponseDto).toList();
    }

    public StudentsResponseDto getStudent(int id){
        Students student = repo.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not found with ID: "+id));
        return mapToResponseDto(student);
    }

    public StudentsResponseDto updateStudent(StudentsRequestDto s, int id){

        Students student = repo.findById(id).orElseThrow(() -> new StudentNotFoundException("No student exist with ID: "+id));
        student.setName(s.getName());
        student.setAge(s.getAge());
        student.setEmail(s.getEmail());
        repo.save(student);

        return mapToResponseDto(student);
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
    
    public StudentsResponseDto mapToResponseDto(Students student){
        StudentsResponseDto dto = new StudentsResponseDto();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setEmail(student.getEmail());
        return dto;
    }

}
