package com.example.academy.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class Teacher {

    @Id
    @GeneratedValue
    private Long id;
    @Size(min = 3, message = "imię musi być dłuższe niż dwie litery")
    private String firstName;
    private String lastName;
    @Min(value = 18, message = "wiek minimalny to 18 lat")
    private Integer age;
    @Email(message = "nie poprawny format adresu email")
    private String email;
    private String subject;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable
    private Set<Student> students = new HashSet<>();

    public void addStudent(Student student) {
        students.add(student);
        student.getTeachers().add(this);
    }
}
