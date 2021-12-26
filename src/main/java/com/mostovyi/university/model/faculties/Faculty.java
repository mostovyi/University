package com.mostovyi.university.model.faculties;

import com.mostovyi.university.model.user.Student;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;

    private String name;

    @OneToMany(mappedBy = "lectures")
    private List<Student> students;

    public Faculty(String name) {
        this.name = name;
    }

    public Faculty() {}

    @Override
    public String toString() {
        return String.format("Faculty of %s id : %d. ",this.name, this.ID);
    }
}
