package com.microservice.course.Http.Response;
import com.microservice.course.Dto.StudentDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentByCouseResponse {
    private String courseName;
    private String teacher;
    private List<StudentDTO> studentDTOList;
}
