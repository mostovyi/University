package com.mostovyi.university.controller;

import com.mostovyi.university.model.enums.Day;
import com.mostovyi.university.model.user.Student;
import com.mostovyi.university.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("students")
public class StudentController {

    private final Logger logger = LoggerFactory.getLogger(StudentController.class);
    private StudentService studentService;

    /*
    * Initializing StudentService
    * */
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
        logger.info("StudentController created.");
    }

    /*
    * Just for testing with HTTP CLIENT, can be useful for future new features
    * */
    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        logger.info("Saving student : {}.", student.toString());
        return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.CREATED);
    }

    /*
     * All users from database
     * */
    @GetMapping
    public String allStudents() {
        logger.info("Searching students...");
        return studentService.getAllStudents().stream().map(Object::toString)
                .collect(Collectors.joining(" | "));
    }

    /*
     * Looking for a User with unique ID
     * */
    @GetMapping("{id}")
    public String getStudentById(@PathVariable Long id) {
        logger.info("Searching Student by id : {}.", id);
        return studentService.findStudentById(id).toString();
    }

    /*
     * Looking for USERs lectures for a specific day
     * */
    @GetMapping("{id}/{day}")
    public String getLecturesByDay(@PathVariable Long id, @PathVariable Day day) {
        logger.info("Searching courses for student id : {}, on {}", id, day.name());
        return this.studentService.getLecturesListForDay(id, day).stream().map(Object::toString)
                .collect(Collectors.joining(" | "));
    }

}
