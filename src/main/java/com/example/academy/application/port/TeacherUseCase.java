package com.example.academy.application.port;

import com.example.academy.domain.Teacher;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TeacherUseCase {

    void createTeacher(Teacher teacher);

    void removeTeacherById(Long id);

    void updateTeacher(Long id, Teacher teacher);

    List<Teacher> findAllTeachers();

    Page<Teacher> findTeachersPaging(int size);

    List<Teacher> findAllTeachersWithSort(String field);

    List<Teacher> findByFirstName(String firstName);

    List<Teacher> findByLastName(String lastName);

    List<Teacher> findByFirstNameAndLastName(String firstName, String lastName);

}
