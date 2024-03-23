package unifor.devweb.project.freelearn.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import unifor.devweb.project.freelearn.domain.AbstractEntity;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseCategory extends AbstractEntity {

    private String name;
    private String description;

    @ManyToMany(mappedBy = "courseCategories")
    private List<Course> courses;

}
