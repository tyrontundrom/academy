package com.example.academy.application;

import com.example.academy.application.port.TeacherUseCase;
import com.example.academy.db.TeacherJpaRepository;
import com.example.academy.domain.Student;
import com.example.academy.domain.Teacher;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
class TeacherService implements TeacherUseCase {

    private final TeacherJpaRepository repository;

    @Override
    public void createTeacher(Teacher teacher) {
        repository.save(teacher);
    }

    @Override
    public void removeTeacherById(Long id) {
        repository.deleteById(id);
    }

    @Transactional
    @Override
    public void updateTeacher(Teacher teacher) {
        Teacher updateTeacher = repository.findById(teacher.getId()).get();
        updateTeacher.setFirstName(teacher.getFirstName());
        updateTeacher.setLastName(teacher.getLastName());
        updateTeacher.setEmail(teacher.getEmail());
        updateTeacher.setAge(teacher.getAge());
        updateTeacher.setSubject(teacher.getSubject());
        repository.save(updateTeacher);
    }

    @Override
    public List<Teacher> findAllTeachers() {
        return repository.findAll();
    }

    @Override
    public Page<Teacher> findTeachersPaging(int size) {
        return repository.findAll(Pageable.ofSize(size));
    }

    @Override
    public List<Teacher> findAllTeachersWithSort(String field) {
        return repository.findAll(Sort.by(field));
    }

    @Override
    public List<Teacher> findByFirstName(String firstName) {
        return repository.findTeacherByFirstName(firstName);
    }

    @Override
    public List<Teacher> findByLastName(String lastName) {
        return repository.findTeacherByLastName(lastName);
    }

    @Override
    public List<Teacher> findByFirstNameAndLastName(String firstName, String lastName) {
        return repository.findTeacherByFirstNameAndLastName(firstName, lastName);
    }


}
