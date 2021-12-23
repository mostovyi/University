package com.mostovyi.university.controller;


import com.mostovyi.university.model.Day;
import com.mostovyi.university.model.Degree;
import com.mostovyi.university.model.faculties.Faculty;
import com.mostovyi.university.model.lectures.Lecture;
import com.mostovyi.university.model.user.Student;
import com.mostovyi.university.repository.FacultyRepository;
import com.mostovyi.university.repository.LectureRepository;
import com.mostovyi.university.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("faculty")
public class UniversityController {

    private final Logger logger = LoggerFactory.getLogger(UniversityController.class);

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private FacultyRepository facultyRepository;
    @Autowired
    private LectureRepository lectureRepository;

    @GetMapping("")
    public List<Faculty> faculties() {
        return facultyRepository.findAll();
    }

    @GetMapping("student")
    public List<Student> university() {

        //Lecture lecture = new Lecture("Math", Day.Monday); lectureRepository.save(lecture);
        //Student student = new Student("New", "Test", Degree.Bachelor, facultyRepository.findFacultiesByName("Informatics"));

        //student.addLecture(lecture); studentRepository.save(student);

        return studentRepository.findAll();
    }

    @GetMapping("student/{id}")
    public Student getStudentById(@PathVariable Long id) {
        logger.error("Here {}.", studentRepository.getById(id).toString());
        return studentRepository.getById(id);
    }
    

}
