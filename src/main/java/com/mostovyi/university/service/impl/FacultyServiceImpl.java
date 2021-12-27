package com.mostovyi.university.service.impl;

import com.mostovyi.university.exceptions.FacultiesNotFound;
import com.mostovyi.university.model.faculties.Faculty;
import com.mostovyi.university.repository.FacultyRepository;
import com.mostovyi.university.service.FacultyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService {

    private final FacultyRepository facultyRepository;
    private final Logger logger = LoggerFactory.getLogger(FacultyServiceImpl.class);

    @Autowired
    public FacultyServiceImpl(FacultyRepository facultyRepository) { this.facultyRepository = facultyRepository; }

    /*
    * Getting Faculties list. Checking if it's empty or not.
    * */
    @Override
    public List<Faculty> showAllFaculties() {
        List<Faculty> facultyList = this.facultyRepository.findAll();

        if(facultyList.isEmpty()) {
            logger.warn("No faculties exists.");
            throw new FacultiesNotFound("Faculties List is empty.");
        }

        logger.info("Faculties found.");
        return facultyList;
    }

}
