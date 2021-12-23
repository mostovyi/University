package com.mostovyi.university.model.user;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.mostovyi.university.model.Degree;
import com.mostovyi.university.model.faculties.Faculty;
import com.mostovyi.university.model.lectures.Lecture;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@JsonIdentityInfo( generator = ObjectIdGenerators.PropertyGenerator.class,  property = "id")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;

    private String firstName;
    private String lastName;

    @Enumerated(EnumType.STRING)
    Degree degree;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "faculty_id", nullable = false)
    Faculty faculty;

    @ManyToMany
    @JoinTable(name="student_lecture",
            joinColumns = @JoinColumn(name="student_id"),
            inverseJoinColumns = @JoinColumn(name="lecture_id"))
    private List<Lecture> lectures = new ArrayList<>();

    public Student(String firstName, String lastName, Degree degree, Faculty faculty) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.degree = degree;
        this.faculty = faculty;
    }

    public Student() {}

    public Long getID() {
        return this.ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Degree getDegree() {
        return this.degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public void addLecture(Lecture lecture) {
        this.lectures.add(lecture);
        lecture.getStudents().add(this);
    }

    @Override
    public String toString() {
        return this.firstName + " | " + this.lastName + " | " + this.degree;
    }

}
