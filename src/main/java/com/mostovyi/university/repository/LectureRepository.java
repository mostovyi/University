package com.mostovyi.university.repository;

import com.mostovyi.university.model.lectures.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureRepository extends JpaRepository<Lecture, Long> {

}
