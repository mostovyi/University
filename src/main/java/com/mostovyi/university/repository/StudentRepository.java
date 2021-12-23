package com.mostovyi.university.repository;

import com.mostovyi.university.model.user.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("select s from Student s where s.ID = :id")
    Student getStudentByID(@Param("id") Long id);

}
