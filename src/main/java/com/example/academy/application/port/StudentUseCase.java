package com.example.academy.application.port;

import com.example.academy.domain.Student;
import com.example.academy.domain.Teacher;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudentUseCase {

    void createStudent(Student student);

    void removeStudentById(Long id);

    void updateStudent(Student student);

    List<Student> findAllStudents();

    Page<Student> findStudentsPaging(int size);

    List<Student> findAllStudentsWithSort(String field);
}
