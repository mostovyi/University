package com.mostovyi.university.controller;

import com.mostovyi.university.model.enums.Day;
import com.mostovyi.university.model.enums.Degree;
import com.mostovyi.university.model.faculties.Faculty;
import com.mostovyi.university.model.lectures.Course;
import com.mostovyi.university.model.user.Student;
import com.mostovyi.university.repository.FacultyRepository;
import com.mostovyi.university.repository.CourseRepository;
import com.mostovyi.university.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
@RequestMapping("/")

/*
* This bean is used just to fill the database with data
* */

public class Controller {

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping
    public void setDataBase() {

        Course mathM = new Course("Math", Day.MONDAY);
        Course mathF = new Course("Math", Day.FRIDAY);
        Course mathW = new Course("Math", Day.WEDNESDAY);
        Course programmingM = new Course("Programming 1", Day.MONDAY);
        Course programmingTu = new Course("Programming 1", Day.TUESDAY);
        Course softEngiTh = new Course("Software Engineering 2", Day.THURSDAY);
        Course softEngiMo = new Course("Software Engineering 2", Day.MONDAY);
        Course softEngiFr = new Course("Software Engineering 2", Day.FRIDAY);
        Course comptGraphTh = new Course("Foundations of Computer Graphics", Day.THURSDAY);
        Course comptGraphW = new Course("Foundations of Computer Graphics", Day.WEDNESDAY);
        Course comptGraphF = new Course("Foundations of Computer Graphics", Day.FRIDAY);
        Course networkTechM = new Course("Network Technologies for Multimedia Applications", Day.MONDAY);
        Course networkTechW = new Course("Network Technologies for Multimedia Applications", Day.WEDNESDAY);
        Course sipM = new Course("Signal and Image Processing", Day.MONDAY);
        Course sipT = new Course("Signal and Image Processing", Day.TUESDAY);
        Course operatingSystemsW = new Course("Operating Systems", Day.WEDNESDAY);
        Course operatingSystemsTh = new Course("Operating Systems", Day.THURSDAY);
        Course operatingSystemsT = new Course("Operating Systems", Day.TUESDAY);
        Course programmingLanguagesW = new Course("Programming Languages and Concepts", Day.WEDNESDAY);
        Course programmingLanguagesT = new Course("Programming Languages and Concepts", Day.THURSDAY);
        Course programmingLanguagesF = new Course("Programming Languages and Concepts", Day.FRIDAY);

        courseRepository.saveAll(new ArrayList<>(Arrays.asList(mathF, mathM, mathW, programmingM, programmingTu, softEngiTh,
                softEngiMo, softEngiFr, comptGraphTh, comptGraphW, comptGraphF, networkTechM, networkTechW,
                sipM, sipT, operatingSystemsW, operatingSystemsTh, operatingSystemsT, programmingLanguagesW,
                programmingLanguagesT, programmingLanguagesF)));

        Faculty faculty = new Faculty("Computer Science");
        Faculty faculty_ = new Faculty("Business and economics");
        facultyRepository.saveAll(Arrays.asList(faculty, faculty_));

        Student student = new Student("Oleg", "Borisov", Degree.BACHELOR);
        Student student2 = new Student("Maxim", "Maximov", Degree.BACHELOR);
        Student student3 = new Student("Jonh", "Smith", Degree.BACHELOR);
        Student student4 = new Student("David", "Davidov", Degree.BACHELOR);

        faculty.addStudent(student);
        faculty.addStudent(student2);
        faculty.addStudent(student3);
        faculty.addStudent(student4);

        student.setCourses(new ArrayList<>(Arrays.asList(mathF, mathM, mathW, programmingM, programmingTu, softEngiTh,
                softEngiMo, softEngiFr, comptGraphTh, comptGraphW, comptGraphF, networkTechM, networkTechW,
                sipM, sipT, operatingSystemsW, operatingSystemsTh, operatingSystemsT, programmingLanguagesW,
                programmingLanguagesT, programmingLanguagesF)));
        student2.setCourses(new ArrayList<>(Arrays.asList(mathF,  mathW, programmingM, programmingTu, softEngiTh,
                softEngiMo, softEngiFr, comptGraphTh, comptGraphW, networkTechW,
                sipM, operatingSystemsTh, operatingSystemsT, programmingLanguagesW,
                programmingLanguagesT, programmingLanguagesF)));
        student3.setCourses(new ArrayList<>(Arrays.asList(comptGraphW, comptGraphF, networkTechM, networkTechW,
                sipM, sipT, operatingSystemsW, operatingSystemsTh, operatingSystemsT, programmingLanguagesW,
                programmingLanguagesT, programmingLanguagesF)));
        student4.setCourses(new ArrayList<>(Arrays.asList(mathF, mathM, mathW, programmingM, programmingTu, softEngiTh,
                softEngiMo, softEngiFr,  networkTechW,
                sipM, sipT, operatingSystemsW, operatingSystemsTh, programmingLanguagesF)));

        studentRepository.saveAll(new ArrayList<>(Arrays.asList(student, student2, student3, student4)));

        //this.facultyRepository.save(faculty);
    }
}
