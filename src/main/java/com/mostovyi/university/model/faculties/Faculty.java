package com.mostovyi.university.model.faculties;

import com.mostovyi.university.model.user.Student;

import javax.persistence.*;
import java.util.List;

@Entity
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;

    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "faculty")
    private List<Student> students;

    public Faculty(String name) {
        this.name = name;
    }

    public Faculty() {}

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
