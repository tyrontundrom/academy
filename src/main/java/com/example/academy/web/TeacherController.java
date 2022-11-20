package com.example.academy.web;

import com.example.academy.application.port.TeacherUseCase;
import com.example.academy.domain.Teacher;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("teacher")
class TeacherController {

    private final TeacherUseCase service;

    @PostMapping
    public void createTeacher(@RequestBody Teacher teacher) {
        service.createTeacher(teacher);
    }

    @DeleteMapping("{id}")
    public void removeTeacher(@PathVariable Long id) {
        service.removeTeacherById(id);
    }

    @PutMapping
    public void updateTeacher(Teacher teacher) {
        service.updateTeacher(teacher);
    }

    @GetMapping
    public List<Teacher> findAllTeachers() {
        return service.findAllTeachers();
    }
}
