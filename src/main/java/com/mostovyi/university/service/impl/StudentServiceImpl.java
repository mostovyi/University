package com.mostovyi.university.service.impl;

import com.mostovyi.university.exceptions.ResourceNotFoundException;
import com.mostovyi.university.model.user.Student;
import com.mostovyi.university.repository.StudentRepository;
import com.mostovyi.university.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student saveStudent(Student student) {
        return this.studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return this.studentRepository.findAll();
    }

    @Override
    public Student findStudentById(Long Id) {
        Student student = this.studentRepository.getById(Id);
        if (student == null) throw new ResourceNotFoundException("Employee", "Id", Id);
        return student;
    }
}
