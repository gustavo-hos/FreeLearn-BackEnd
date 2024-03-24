package unifor.devweb.project.freelearn.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import unifor.devweb.project.freelearn.domain.dto.CourseDTO;
import unifor.devweb.project.freelearn.domain.entities.Course;
import unifor.devweb.project.freelearn.mapper.CourseMapper;
import unifor.devweb.project.freelearn.repository.CourseRepository;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper = CourseMapper.INSTANCE;

    public Page<CourseDTO> listAll(Pageable pageable) {
        return courseRepository.findAll(pageable)
                .map(courseMapper::courseToCourseDTO);
    }

    public List<CourseDTO> listAllNonPageable() {
        return courseRepository.findAll().stream()
                .map(courseMapper::courseToCourseDTO)
                .collect(Collectors.toList());
    }

    public CourseDTO findById(long id) {
        Course course = findCourseById(id);
        return courseMapper.courseToCourseDTO(course);
    }

    @Transactional
    public CourseDTO save(CourseDTO courseDTO) {
        Course course = courseMapper.courseDTOToCourse(courseDTO);
        Course savedCourse = courseRepository.save(course);
        return courseMapper.courseToCourseDTO(savedCourse);
    }

    @Transactional
    public void delete(long id) {
        Course course = findCourseById(id);
        courseRepository.delete(course);
    }

    @Transactional
    public CourseDTO update(CourseDTO courseDTO) {
        Course course = courseMapper.courseDTOToCourse(courseDTO);
        Course updatedCourse = courseRepository.save(course);
        return courseMapper.courseToCourseDTO(updatedCourse);
    }

    private Course findCourseById(long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Course not found with id: " + id));
    }
}
