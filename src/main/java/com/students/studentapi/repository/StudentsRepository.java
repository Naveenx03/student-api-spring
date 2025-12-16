package com.students.studentapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.students.studentapi.model.Students;

public interface StudentsRepository extends JpaRepository<Students,Integer> {

}
