package com.mostovyi.university.service;

import com.mostovyi.university.model.enums.Day;
import com.mostovyi.university.model.lectures.Lecture;
import com.mostovyi.university.model.user.Student;

import java.util.List;

public interface StudentService {

    Student saveStudent(Student student);
    List<Student> getAllStudents();
    Student findStudentById(Long id);
    List<Lecture> getLecturesListForDay(Long id, Day day);

}
