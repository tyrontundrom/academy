package com.example.academy.application;

import com.example.academy.application.port.StudentUseCase;
import com.example.academy.db.StudentJpaRepository;
import com.example.academy.domain.Student;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
class StudentService implements StudentUseCase {

    private final StudentJpaRepository repository;

    @Override
    public void createStudent(Student student) {
        repository.save(student);
    }

    @Override
    public void removeStudentById(Long id) {
        repository.deleteById(id);
    }

    @Transactional
    @Override
    public void updateStudent(Student student) {
        Student updateStudent = repository.findById(student.getId()).get();
        updateStudent.setFirstName(student.getFirstName());
        updateStudent.setLastName(student.getLastName());
        updateStudent.setEmail(student.getEmail());
        updateStudent.setAge(student.getAge());
        updateStudent.setSubject(student.getSubject());
        repository.save(updateStudent);
    }

    @Override
    public List<Student> findAllStudents() {
        return repository.findAll();
    }
}
