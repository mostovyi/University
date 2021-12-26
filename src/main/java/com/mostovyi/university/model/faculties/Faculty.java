package com.mostovyi.university.model.faculties;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mostovyi.university.model.user.Student;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter
    @Getter
    private Long id;

    @Setter
    @Getter
    private String name;

    @OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL, orphanRemoval = true)
    @Setter
    @Getter
    @JsonBackReference
    private List<Student> students = new ArrayList<>();

    public Faculty(String name) {
        this.name = name;
    }

    public Faculty() {}

    public void addStudent(Student student) {
        students.add(student);
        student.setFaculty(this);
    }
    @Override
    public String toString() {
        return String.format("Faculty of %s id : %d. ",this.name, this.id);
    }
}
