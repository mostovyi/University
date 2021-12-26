package com.mostovyi.university.model.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mostovyi.university.model.enums.Degree;
import com.mostovyi.university.model.faculties.Faculty;
import com.mostovyi.university.model.lectures.Course;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter
    @Getter
    private Long id;

    @Setter
    @Getter
    private String firstName;

    @Setter
    @Getter
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Setter
    @Getter
    private Degree degree;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="faculty_id", nullable=false)
    @Setter
    @Getter
    private Faculty faculty;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinTable(
            name = "student_course",
            joinColumns = { @JoinColumn(name = "student_id") },
            inverseJoinColumns = { @JoinColumn(name = "course_id") }
    )
    @Setter
    @Getter
    private List<Course> courses = new ArrayList<>();

    public Student(String firstName, String lastName, Degree degree) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.degree = degree;
    }

    public Student() {}

    @Override
    public String toString() {
        return String.format("%s %s, id : %d, becoming %s degree.", this.firstName, this.lastName, this.id, this.degree.name());
    }

}
