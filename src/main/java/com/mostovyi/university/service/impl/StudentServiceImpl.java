package com.mostovyi.university.service.impl;

import com.mostovyi.university.exceptions.ResourceNotFoundException;
import com.mostovyi.university.model.enums.Day;
import com.mostovyi.university.model.lectures.Lecture;
import com.mostovyi.university.model.user.Student;
import com.mostovyi.university.repository.StudentRepository;
import com.mostovyi.university.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
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
        List<Student> studentList = this.studentRepository.findAll();

        if(studentList.isEmpty()) { logger.warn("No students found!"); }

        logger.info("Students found.");

        return studentList;
    }

    @Override
    public Student findStudentById(Long id) { return this.studentRepository.findById(id).orElseThrow(() -> {
        logger.error("Student with following id : {} is not found.", id);
        return new ResourceNotFoundException("Employee", "Id", id);}); }

    @Override
    public List<Lecture> getLecturesListForDay(Long id, Day day) {
        List<Lecture> lectureList = studentRepository.getAllByLecturesDay(id, day);

        if(lectureList.isEmpty()) { logger.warn("No lectures found!"); }

        logger.info("Lectures found.");
        return lectureList;
    }
}
