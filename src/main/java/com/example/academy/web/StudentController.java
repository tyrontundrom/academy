package com.example.academy.web;

import com.example.academy.application.port.StudentUseCase;
import com.example.academy.domain.Student;
import com.example.academy.domain.Teacher;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("student")
class StudentController {

    private final StudentUseCase service;

    @PostMapping
    public void createStudent(@RequestBody Student student) {
        service.createStudent(student);
    }

    @DeleteMapping("{id}")
    public void removeStudent(@PathVariable Long id) {
        service.removeStudentById(id);
    }

    @PutMapping
    public void updateTeacher(Student student) {
        service.updateStudent(student);
    }

    @GetMapping
    public List<Student> findAllStudents() {
        return service.findAllStudents();
    }

}
