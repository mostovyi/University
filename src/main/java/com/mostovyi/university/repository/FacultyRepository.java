package com.mostovyi.university.repository;

import com.mostovyi.university.model.faculties.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {

    @Query("select f from Faculty f where f.ID = :id")
    Faculty findFacultiesByName(@Param("id") Long id);

}
