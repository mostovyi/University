package com.mostovyi.university.service;

import com.mostovyi.university.model.user.Student;
import com.mostovyi.university.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceStudentImpl {

    @Autowired
    private StudentRepository studentRepository;


}
