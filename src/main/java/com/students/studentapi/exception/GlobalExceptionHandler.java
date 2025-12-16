package com.students.studentapi.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public Map<String,String> handlesStudentError(StudentNotFoundException e){
        
        Map<String,String> error = new HashMap<>();
        error.put("error", e.getMessage());
        return error;
        
    }

}
