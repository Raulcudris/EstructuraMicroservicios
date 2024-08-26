package com.microservice.student.Persitence;
import com.microservice.student.Entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository  extends CrudRepository<Student, Long> {

    String FILTER_STUDENTS_BY_COURSE_QUERY = "SELECT c FROM Student c WHERE c.courseId  =:courseId ";
    @Query(value =FILTER_STUDENTS_BY_COURSE_QUERY)
    List<Student> findAllByCourseId(@Param("courseId") Long courseId);
}
