package com.microservice.course.Services;

import com.microservice.course.Client.StudentClient;
import com.microservice.course.Dto.StudentDTO;
import com.microservice.course.Entity.Course;
import com.microservice.course.Http.Response.StudentByCouseResponse;
import com.microservice.course.Persistence.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService {
    @Autowired
    private ICourseRepository courseRepository;

    @Autowired
    private StudentClient studentClient;

    @Override
    public List<Course> findAll() {
        return (List<Course>) courseRepository.findAll();
    }

    @Override
    public Course findById(Long id) {
        return courseRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Course course) {
        courseRepository.save(course);
    }

   @Override
    public StudentByCouseResponse findStudentsByCourseId(Long courseId) {

        // Consultar si existe el curso
        Course course = courseRepository.findById(courseId).orElseThrow();

        // Obtener los estudiantes
        List<StudentDTO> studentDTOList = studentClient.findAllStudentByCourse(course.getId());

        return StudentByCouseResponse.builder()
                .courseName(course.getName())
                .teacher(course.getTeacher())
                .studentDTOList(studentDTOList)
                .build();
    }
}
