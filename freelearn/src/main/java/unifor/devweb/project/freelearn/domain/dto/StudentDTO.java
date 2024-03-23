package unifor.devweb.project.freelearn.domain.dto;

import lombok.Data;

import java.util.List;

@Data
public class StudentDTO {
    private Long id;
    private String name;
    private String email;
    private int hoursWatched;
    private int numberOfCoursesSubscribed;
    private List<Long> enrolledCourseIds;
}
