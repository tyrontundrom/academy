package com.example.academy.application;

import com.example.academy.application.port.StudentUseCase;
import com.example.academy.db.StudentJpaRepository;
import com.example.academy.domain.Student;
import com.example.academy.domain.Teacher;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @Override
    public Page<Student> findStudentsPaging(int size) {
        return repository.findAll(Pageable.ofSize(size));
    }

    @Override
    public List<Student> findAllStudentsWithSort(String field) {
        return repository.findAll(Sort.by(field));
    }

    @Override
    public List<Student> findByFirstName(String firstName) {
        return repository.findStudentByFirstName(firstName);
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        return repository.findStudentByLastName(lastName);
    }

    @Override
    public List<Student> findByFirstNameAndLastName(String firstName, String lastName) {
        return repository.findStudentByFirstNameAndLastName(firstName, lastName);
    }
}
