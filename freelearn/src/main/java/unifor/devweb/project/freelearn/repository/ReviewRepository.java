package unifor.devweb.project.freelearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unifor.devweb.project.freelearn.domain.entities.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
