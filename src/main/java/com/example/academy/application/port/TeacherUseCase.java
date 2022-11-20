package com.example.academy.application.port;

import com.example.academy.domain.Teacher;

import java.util.List;

public interface TeacherUseCase {

    void createTeacher(Teacher teacher);

    void removeTeacherById(Long id);

    void updateTeacher(Teacher teacher);

    List<Teacher> findAllTeachers();
}
