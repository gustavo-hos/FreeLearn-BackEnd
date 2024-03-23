package unifor.devweb.project.freelearn.domain.dto;

import lombok.Data;

import java.util.List;

@Data
public class TeacherDTO {
    private Long id;
    private String name;
    private String email;
    private String employeeId;
    private List<String> areasOfExpertise;
    private double overallRating;
    private int hoursTaught;
    private List<Long> coursesTaughtIds;
}
