package unifor.devweb.project.freelearn.domain.dto;

import lombok.Data;

import java.util.List;

@Data
public class CourseDTO {
    private Long id;
    private String title;
    private String description;
    private String imageUrl;
    private String language;
    private int durationHours;
    private String link;
    private List<Long> courseCategoryIds;
    private List<Long> enrolledStudentIds;
    private List<Long> teacherIds;
}
