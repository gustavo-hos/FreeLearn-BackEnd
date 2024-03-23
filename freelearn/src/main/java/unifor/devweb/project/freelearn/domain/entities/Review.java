package unifor.devweb.project.freelearn.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import unifor.devweb.project.freelearn.domain.AbstractEntity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review extends AbstractEntity {

    private String comment;

    @ManyToOne
    private Student student;
    @ManyToOne
    private Course course;
    @ManyToOne
    private Teacher teacher;
}
