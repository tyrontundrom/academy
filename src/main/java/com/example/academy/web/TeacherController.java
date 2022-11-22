package com.example.academy.web;

import com.example.academy.application.port.StudentUseCase;
import com.example.academy.application.port.TeacherUseCase;
import com.example.academy.domain.Teacher;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("teacher")
class TeacherController {

    private final TeacherUseCase service;
    private final StudentUseCase studentUseCase;

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

    @GetMapping("page/{size}")
    public Page<Teacher> findTeachersPaging(@PathVariable int size) {
        return service.findTeachersPaging(size);
    }

    @GetMapping("sort/{field}")
    public List<Teacher> findAllTeachersWithSort(@PathVariable String field) {
        return service.findAllTeachersWithSort(field);
    }
}
