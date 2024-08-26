package com.microservice.course.Services;
import com.microservice.course.Entity.Course;
import com.microservice.course.Http.Response.StudentByCouseResponse;

import java.util.List;

public interface ICourseService {
    List<Course> findAll();
    Course findById(Long id);
    void save(Course course);
    StudentByCouseResponse findStudentsByCourseId(Long courseId);
}
