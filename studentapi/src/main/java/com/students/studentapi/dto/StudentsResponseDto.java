package com.students.studentapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class StudentsResponseDto {
    @Schema(
        description = "Unique ID of the student",
        example = "1"
    )
    private int id;

    @Schema(
        description = "Full name of the student",
        example = "Naveen G"
    )
    private String name;

    @Schema(
        description = "Email address of the student",
        example = "naveen@gmail.com"
    )
    private String email;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    

     
}
