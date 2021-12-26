package com.mostovyi.university.controller;

import com.mostovyi.university.model.enums.Day;
import com.mostovyi.university.model.enums.Degree;
import com.mostovyi.university.model.faculties.Faculty;
import com.mostovyi.university.model.lectures.Lecture;
import com.mostovyi.university.model.user.Student;
import com.mostovyi.university.repository.FacultyRepository;
import com.mostovyi.university.repository.LectureRepository;
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
    private LectureRepository lectureRepository;

    @GetMapping
    public void setDataBase() {

        Lecture mathM = new Lecture("Math", Day.MONDAY);
        Lecture mathF = new Lecture("Math", Day.FRIDAY);
        Lecture mathW = new Lecture("Math", Day.WEDNESDAY);
        Lecture programmingM = new Lecture("Programming 1", Day.MONDAY);
        Lecture programmingTu = new Lecture("Programming 1", Day.TUESDAY);
        Lecture softEngiTh = new Lecture("Software Engineering 2", Day.THURSDAY);
        Lecture softEngiMo = new Lecture("Software Engineering 2", Day.MONDAY);
        Lecture softEngiFr = new Lecture("Software Engineering 2", Day.FRIDAY);
        Lecture comptGraphTh = new Lecture("Foundations of Computer Graphics", Day.THURSDAY);
        Lecture comptGraphW = new Lecture("Foundations of Computer Graphics", Day.WEDNESDAY);
        Lecture comptGraphF = new Lecture("Foundations of Computer Graphics", Day.FRIDAY);
        Lecture networkTechM = new Lecture("Network Technologies for Multimedia Applications", Day.MONDAY);
        Lecture networkTechW = new Lecture("Network Technologies for Multimedia Applications", Day.WEDNESDAY);
        Lecture sipM = new Lecture("Signal and Image Processing", Day.MONDAY);
        Lecture sipT = new Lecture("Signal and Image Processing", Day.TUESDAY);
        Lecture operatingSystemsW = new Lecture("Operating Systems", Day.WEDNESDAY);
        Lecture operatingSystemsTh = new Lecture("Operating Systems", Day.THURSDAY);
        Lecture operatingSystemsT = new Lecture("Operating Systems", Day.TUESDAY);
        Lecture programmingLanguagesW = new Lecture("Programming Languages and Concepts", Day.WEDNESDAY);
        Lecture programmingLanguagesT = new Lecture("Programming Languages and Concepts", Day.THURSDAY);
        Lecture programmingLanguagesF = new Lecture("Programming Languages and Concepts", Day.FRIDAY);

        lectureRepository.saveAll(new ArrayList<>(Arrays.asList(mathF, mathM, mathW, programmingM, programmingTu, softEngiTh,
                softEngiMo, softEngiFr, comptGraphTh, comptGraphW, comptGraphF, networkTechM, networkTechW,
                sipM, sipT, operatingSystemsW, operatingSystemsTh, operatingSystemsT, programmingLanguagesW,
                programmingLanguagesT, programmingLanguagesF)));

        Faculty faculty = new Faculty("Computer Science");
        Faculty faculty_ = new Faculty("Business and economics");
        facultyRepository.saveAll(Arrays.asList(faculty, faculty_));

        Student student = new Student("Oleg", "Borisov", Degree.BACHELOR, faculty);
        Student student2 = new Student("Maxim", "Maximov", Degree.BACHELOR, faculty);
        Student student3 = new Student("Jonh", "Smith", Degree.BACHELOR, faculty);
        Student student4 = new Student("David", "Davidov", Degree.BACHELOR, faculty);

        student.setLectures(new ArrayList<>(Arrays.asList(mathF, mathM, mathW, programmingM, programmingTu, softEngiTh,
                softEngiMo, softEngiFr, comptGraphTh, comptGraphW, comptGraphF, networkTechM, networkTechW,
                sipM, sipT, operatingSystemsW, operatingSystemsTh, operatingSystemsT, programmingLanguagesW,
                programmingLanguagesT, programmingLanguagesF)));
        student2.setLectures(new ArrayList<>(Arrays.asList(mathF,  mathW, programmingM, programmingTu, softEngiTh,
                softEngiMo, softEngiFr, comptGraphTh, comptGraphW, networkTechW,
                sipM, operatingSystemsTh, operatingSystemsT, programmingLanguagesW,
                programmingLanguagesT, programmingLanguagesF)));
        student3.setLectures(new ArrayList<>(Arrays.asList(comptGraphW, comptGraphF, networkTechM, networkTechW,
                sipM, sipT, operatingSystemsW, operatingSystemsTh, operatingSystemsT, programmingLanguagesW,
                programmingLanguagesT, programmingLanguagesF)));
        student4.setLectures(new ArrayList<>(Arrays.asList(mathF, mathM, mathW, programmingM, programmingTu, softEngiTh,
                softEngiMo, softEngiFr,  networkTechW,
                sipM, sipT, operatingSystemsW, operatingSystemsTh, programmingLanguagesF)));

        studentRepository.saveAll(new ArrayList<>(Arrays.asList(student, student2, student3, student4)));

        faculty.setStudents(new ArrayList<>(Arrays.asList(student, student2, student3, student4)));
        this.facultyRepository.save(faculty);
    }
}
