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

import com.students.studentapi.dto.StudentsRequestDto;
import com.students.studentapi.dto.StudentsResponseDto;
import com.students.studentapi.exception.ErrorResponse;
import com.students.studentapi.service.StudentsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;


@Tag(
    name = "Student Management",
    description = "APIs for managing students (create, read, update, delete)"
)

@RestController
@RequestMapping("/students")
public class StudentsController {

    @Autowired
    private StudentsService service;

    @Operation(
        summary = "Get all students",
        description = "Fetches all students from the database"
    )
    @GetMapping
    public List<StudentsResponseDto> Students(){
        return service.getStudents();
    }

    @Operation(
        summary = "Get student by ID",
        description = "Fetches a single student using their unique ID"
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Student found"),
        @ApiResponse(responseCode = "404", 
                    description = "Student not found", 
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))
                    )
    })
    @GetMapping("/{id}")
    public StudentsResponseDto student(@PathVariable int id){
        return service.getStudent(id);
    }

    @Operation(
        summary = "Create a new student",
        description = "Creates a new student after validating input data"
    )
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Student created successfully"),
        @ApiResponse(responseCode = "400", description = "Validation error")
    })
    @PostMapping
    public StudentsResponseDto create(@Valid @RequestBody StudentsRequestDto student){
        return service.addStudent(student);
    }

    @Operation(
        summary = "Update student using their unique ID",
        description = "Updates student after validating input data"
    )
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Student updated successfully"),
        @ApiResponse(responseCode = "404", 
                    description = "Student not found", 
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))
                    )
    })
    @PutMapping("{id}")
    public StudentsResponseDto update(@Valid @RequestBody StudentsRequestDto student, @PathVariable int id){
        return service.updateStudent(student, id);
    }

    @Operation(
        summary = "Delete student database",
        description = "Clears entire student records from the database"
    )
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Student database cleared")
    })
    @DeleteMapping
    public String delete(){
        return service.deleteStudents();
    }

    @Operation(
        summary = "Delete student using thier unique ID",
        description = "Deletes student using their unique ID"
    )
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Student deleted successfully"),
        @ApiResponse(responseCode = "404", 
                    description = "Student not found", 
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))
                    )
    })
    @DeleteMapping("{id}")
    public String delete(@PathVariable int id){
        return service.deleteStudentById(id);
    }

}
