package com.students.studentapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class StudentsRequestDto {

    @Schema(
        description = "Full name of the student",
        example = "Naveen G"
    )
    @NotBlank(message = "Name cannot be empty")
    private String name;

    @Schema(
        description = "Email address of the student",
        example = "naveen@gmail.com"
    )
    @Email(message = "Email is not valid")
    private String email;

    @Schema(
        description = "Age of the student",
        example = "22"
    )
    @Min(value = 1, message = "Age must be greater than 0")
    private int age;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    

}
