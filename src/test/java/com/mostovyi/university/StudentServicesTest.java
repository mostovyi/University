package com.mostovyi.university;

import com.mostovyi.university.exceptions.ResourceNotFoundException;
import com.mostovyi.university.model.enums.Degree;
import com.mostovyi.university.model.user.Student;
import com.mostovyi.university.repository.StudentRepository;
import com.mostovyi.university.service.impl.StudentServiceImpl;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServicesTest {
    @MockBean
    StudentRepository studentRepository;

    @Autowired
    StudentServiceImpl studentService;

    /*
    * StudentRepository must be called when
    *  user must be saved
    * */
    @Test
    public void when_we_saving_user_it_should_call_student_repository() {

        Student testStudent = new Student("test", "test", Degree.BACHELOR);
        studentService.saveStudent(testStudent);
        Mockito.verify(studentRepository, Mockito.times(1)).save(testStudent);

    }

    /*
     * Saving user operation must return User
     * */
    @Test
    public void when_save_user_it_should_return_user() {

        Student testStudent = new Student("test", "test", Degree.BACHELOR);
        when(studentRepository.save(Mockito.any(Student.class))).thenAnswer(i -> i.getArguments()[0]);
        Student createdUser = studentService.saveStudent(testStudent);
        Assert.assertEquals(testStudent.getFirstName(), createdUser.getFirstName());

    }

    /*
     * Search by ID have to return a User
     * */
    @Test
    public void when_we_want_to_find_user_by_id_should_return_user_with_id() {

        Student testStudentFirst = new Student("test1", "test1", Degree.BACHELOR);
        testStudentFirst.setId(1L);
        when(studentRepository.findById(1L)).thenReturn(Optional.of(testStudentFirst));
        Student foundUser = studentService.findStudentById(1L);
        final Long expected = 1L;
        Assert.assertEquals(expected, foundUser.getId());

    }

    /*
    * If user is not found, ResourceNotFoundException must be thrown
    * */
    @Test(expected = ResourceNotFoundException.class)
    public void when_we_want_to_find_user_by_id_should_return_error() {

        Student testStudentFirst = new Student("test1", "test1", Degree.BACHELOR);
        testStudentFirst.setId(2L);
        when(studentRepository.findById(1L)).thenThrow(new ResourceNotFoundException("Student", "id", 1L));
        studentService.findStudentById(1L);

    }

    /*
    * Cheking list size after findAll() method
    * */
    @Test
    public void want_all_users_list_should_return_users_list_with_expected_size() {

        when(studentRepository.findAll()).thenReturn( Arrays.asList(new Student("test1", "test1", Degree.BACHELOR),
                new Student("test2", "test2", Degree.BACHELOR)) );
        List<Student> expected = studentService.getAllStudents();
        final int expectedSize = 2;
        Assert.assertEquals(expectedSize, expected.size());

    }
}
