package com.mostovyi.university.repository;

import com.mostovyi.university.model.enums.Day;
import com.mostovyi.university.model.lectures.Course;
import com.mostovyi.university.model.user.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT c FROM Student s, Course c where s.id = ?1 and c.day = ?2")
    List<Course> getAllByLecturesDay(Long id, Day day);

}
