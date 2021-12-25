package com.mostovyi.university.model.lectures;

import com.fasterxml.jackson.annotation.*;
import com.mostovyi.university.model.Day;
import com.mostovyi.university.model.user.Student;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
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

}
