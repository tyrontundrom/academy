package com.example.academy.web;

import com.example.academy.application.port.StudentUseCase;
import com.example.academy.domain.Student;
import com.example.academy.domain.Teacher;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public List<Student> findAllStudents(
            @RequestParam Optional<String> firstName,
            @RequestParam Optional<String> lastName) {
        if (firstName.isPresent() & lastName.isPresent()) {
            return service.findByFirstNameAndLastName(firstName.get(), lastName.get());
        } else if (firstName.isPresent()) {
            return service.findByFirstName(firstName.get());
        } else if (lastName.isPresent()) {
            return service.findByLastName(lastName.get());
        } else {
            return service.findAllStudents();
        }
    }

    @GetMapping("page/{size}")
    public Page<Student> findStudentsPaging(@PathVariable int size) {
        return service.findStudentsPaging(size);
    }

    @GetMapping("sort/{field}")
    public List<Student> findAllStudentsWithSort(@PathVariable String field) {
        return service.findAllStudentsWithSort(field);
    }
}
