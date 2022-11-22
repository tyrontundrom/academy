package com.example.academy.db;

import com.example.academy.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherJpaRepository extends JpaRepository<Teacher, Long> {

    List<Teacher> findTeacherByFirstName(String firstName);

    List<Teacher> findTeacherByLastName(String lastName);

    List<Teacher> findTeacherByFirstNameAndLastName(String firstName, String lastName);
}
