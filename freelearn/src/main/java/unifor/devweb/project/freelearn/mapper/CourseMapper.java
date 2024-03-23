package unifor.devweb.project.freelearn.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import unifor.devweb.project.freelearn.domain.dto.CourseDTO;
import unifor.devweb.project.freelearn.domain.entities.Course;

@Mapper
public interface CourseMapper {

    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

    @Mapping(source = "courseCategories", target = "courseCategoryIds")
    @Mapping(source = "enrolledStudents", target = "enrolledStudentIds")
    @Mapping(source = "instructors", target = "teacherIds")
    CourseDTO courseToCourseDTO(Course course);

    @Mapping(source = "courseCategoryIds", target = "courseCategories")
    @Mapping(source = "enrolledStudentIds", target = "enrolledStudents")
    @Mapping(source = "teacherIds", target = "instructors")
    Course courseDTOToCourse(CourseDTO courseDTO);
}
