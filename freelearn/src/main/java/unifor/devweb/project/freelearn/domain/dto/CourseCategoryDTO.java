package unifor.devweb.project.freelearn.domain.dto;

import lombok.Data;

import java.util.List;

@Data
public class CourseCategoryDTO {
    private Long id;
    private String name;
    private String description;
    private List<Long> courseIds;
}
