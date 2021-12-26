package com.mostovyi.university.model.lectures;

import com.fasterxml.jackson.annotation.*;
import com.mostovyi.university.model.enums.Day;
import com.mostovyi.university.model.user.Student;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter
    @Getter
    private Long ID;

    @Setter
    @Getter
    private String name;

    @Enumerated(EnumType.STRING)
    @Setter
    @Getter
    private Day day;

    @ManyToMany(mappedBy = "courses")
    @Setter
    @Getter
    private List<Student> students = new ArrayList<>();

    public Course(String name, Day day) {
        this.name = name;
        this.day = day;
    }

    public Course() {}

    @Override
    public String toString() {
        return String.format("%s course, id is : %d, day : %s", this.name, this.ID, this.day.name());
    }
}
