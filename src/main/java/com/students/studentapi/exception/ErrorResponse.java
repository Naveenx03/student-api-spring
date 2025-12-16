package com.students.studentapi.exception;

import io.swagger.v3.oas.annotations.media.Schema;

public class ErrorResponse {

    @Schema(
        description = "Error message returned by the API",
        example = "Student not found with ID: 10"
    )
    private String error;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    
}
