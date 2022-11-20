package com.example.academy.application.port;

import com.example.academy.domain.Student;

import java.util.List;

public interface StudentUseCase {

    void createStudent(Student student);

    void removeStudentById(Long id);

    void updateStudent(Student student);

    List<Student> findAllStudents();
}
