package com.example.academy.application.port;

import com.example.academy.domain.Student;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudentUseCase {

    void createStudent(Student student);

    void removeStudentById(Long id);

    void updateStudent(Long id, Student student);

    List<Student> findAllStudents();

    Page<Student> findStudentsPaging(int size);

    List<Student> findAllStudentsWithSort(String field);

    List<Student> findByFirstName(String firstName);

    List<Student> findByLastName(String lastName);

    List<Student> findByFirstNameAndLastName(String firstName, String lastName);
}
