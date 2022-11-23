package com.example.academy.db;

import com.example.academy.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentJpaRepository extends JpaRepository<Student, Long> {

    List<Student> findStudentByFirstName(String firstName);

    List<Student> findStudentByLastName(String lastName);

    List<Student> findStudentByFirstNameAndLastName(String firstName, String lastName);
}
