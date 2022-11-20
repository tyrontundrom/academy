package com.example.academy.db;

import com.example.academy.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherJpaRepository extends JpaRepository<Teacher, Long> {
}
