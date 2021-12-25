package com.mostovyi.university.model.user;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.mostovyi.university.model.Degree;
import com.mostovyi.university.model.faculties.Faculty;
import com.mostovyi.university.model.lectures.Lecture;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
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
    
    @Override
    public String toString() {
        return this.firstName + " | " + this.lastName + " | " + this.degree;
    }

}
