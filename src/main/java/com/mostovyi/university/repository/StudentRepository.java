package com.mostovyi.university.repository;

import com.mostovyi.university.model.enums.Day;
import com.mostovyi.university.model.lectures.Lecture;
import com.mostovyi.university.model.user.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT l FROM Student s, Lecture l where s.ID = ?1 and l.day = ?2")
    List<Lecture> getAllByLecturesDay(Long id, Day day);

}
