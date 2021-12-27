package com.mostovyi.university.controller;


import com.mostovyi.university.service.FacultyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("faculty")
public class FacultyController {

    private final Logger logger = LoggerFactory.getLogger(FacultyController.class);
    private final FacultyService facultyService;

    /*
     * FacultyService initializing
     * */
    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
        logger.info("FacultyController created.");
    }

    /*
     * Getting all FACULTIES from database
     * */
    @GetMapping
    public String faculties() {
        logger.info("Parsing all faculties from database.");
        return facultyService.showAllFaculties().stream().map(Object::toString)
                .collect(Collectors.joining(" | "));
    }

}
