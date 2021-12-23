package com.mostovyi.university.model.lectures;

import com.fasterxml.jackson.annotation.*;
import com.mostovyi.university.model.Day;
import com.mostovyi.university.model.user.Student;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;

    private String name;

    @Enumerated(EnumType.STRING)
    private Day day;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "lectures")
    private List<Student> students = new ArrayList<>();;

    public Lecture(String name, Day day) {
        this.name = name;
        this.day = day;
    }

    public Lecture() {}

    public Long getID() {
        return this.ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Day getDay() {
        return this.day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
