package unifor.devweb.project.freelearn.domain.dto;

import lombok.Data;

import java.util.List;

@Data
public class CourseModuleDTO {
    private Long id;
    private String title;
    private String description;
    private int sequenceNumber;
    private Long courseId;
    private List<Long> lessonIds;
}
