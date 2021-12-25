package com.mostovyi.university.service;

import com.mostovyi.university.model.user.Student;

import java.util.List;

public interface StudentService {

    Student saveStudent(Student student);
    List<Student> getAllStudents();
    Student findStudentById(Long Id);

}
