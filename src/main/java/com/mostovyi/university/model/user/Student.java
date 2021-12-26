package com.mostovyi.university.model.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mostovyi.university.model.enums.Degree;
import com.mostovyi.university.model.faculties.Faculty;
import com.mostovyi.university.model.lectures.Lecture;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;

    private String firstName;
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Degree degree;

    @ManyToOne
    @JoinColumn(name="faculty_id", nullable=false)
    private Faculty faculty;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinTable(
            name = "Student_Lecture",
            joinColumns = { @JoinColumn(name = "student_id") },
            inverseJoinColumns = { @JoinColumn(name = "lecture_id") }
    )
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
        return String.format("%s %s, id : %d, becoming %s degree.", this.firstName, this.lastName, this.ID, this.degree.name());
    }

}
