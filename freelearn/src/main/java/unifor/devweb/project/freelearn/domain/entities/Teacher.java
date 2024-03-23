package unifor.devweb.project.freelearn.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Teacher extends User{

    private String employeeId;
    private List<String> areasOfExpertise;
    private double overallRating;
    private int hoursTaught;

    @OneToMany
    private List<Course> coursesTaught;

}
