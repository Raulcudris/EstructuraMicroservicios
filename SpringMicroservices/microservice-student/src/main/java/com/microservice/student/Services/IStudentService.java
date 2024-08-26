package com.microservice.student.Services;

import com.microservice.student.Entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    Student findById(Long id);
    void save(Student student);
    List<Student> findByCourseId(Long courseId);

}
