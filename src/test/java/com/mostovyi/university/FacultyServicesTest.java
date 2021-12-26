package com.mostovyi.university;

import com.mostovyi.university.exceptions.FacultiesNotFound;
import com.mostovyi.university.model.faculties.Faculty;
import com.mostovyi.university.repository.FacultyRepository;
import com.mostovyi.university.service.impl.FacultyServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FacultyServicesTest {

    @MockBean
    FacultyRepository facultyRepository;

    @Autowired
    FacultyServiceImpl facultyService;

    @Test
    public void want_all_users_list_should_return_users_list_with_expected_size() {

        when(facultyRepository.findAll()).thenReturn( Arrays.asList(new Faculty("Math"),
                                new Faculty("Physics")));
        List<Faculty> expected = facultyService.showAllFaculties();
        final int expectedSize = 2;
        Assert.assertEquals(expectedSize, expected.size());

    }

    @Test(expected = FacultiesNotFound.class)
    public void when_we_want_to_find_faculties_should_return_error() {

        when(facultyRepository.findAll()).thenThrow(new FacultiesNotFound(""));
        facultyService.showAllFaculties();
    }
}
