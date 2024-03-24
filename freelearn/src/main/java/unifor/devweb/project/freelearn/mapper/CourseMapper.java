package unifor.devweb.project.freelearn.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import unifor.devweb.project.freelearn.domain.AbstractEntity;
import unifor.devweb.project.freelearn.domain.dto.CourseDTO;
import unifor.devweb.project.freelearn.domain.entities.Course;
import unifor.devweb.project.freelearn.domain.entities.CourseCategory;
import unifor.devweb.project.freelearn.domain.entities.Student;
import unifor.devweb.project.freelearn.domain.entities.Teacher;

import java.util.List;
import java.util.stream.Collectors;

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

    default List<Long> mapCourseCategoryIds(List<CourseCategory> categories) {
        return this.entityIdMapper(categories);
    }

    default List<Long> mapEnrolledStudentIds(List<Student> students) {
        return this.entityIdMapper(students);
    }

    default List<Long> mapTeacherIds(List<Teacher> teachers) {
        return this.entityIdMapper(teachers);
    }

    default List<CourseCategory> mapCourseCategoryIdsToCourse(List<Long> categories) {
        return this.fromIdMapper(categories, CourseCategory.class);
    }

    default List<Student> mapEnrolledStudentIdsToStudent(List<Long> students) {
        return this.fromIdMapper(students, Student.class);
    }

    default List<Teacher> mapTeacherIdsToTeacher(List<Long> teachers) {
        return this.fromIdMapper(teachers, Teacher.class);
    }

    default <E extends AbstractEntity> List<Long> entityIdMapper(List<E> entities) {
        return entities.stream()
                .map((AbstractEntity::getId))
                .collect(Collectors.toList());
    }

    default <E extends AbstractEntity> List<E> fromIdMapper(List<Long> idEntities, Class<E> clazz) {
        return idEntities.stream()
                .map(id -> {
                    try {
                        var classConstructor = clazz.getConstructor();
                        var objInstance = classConstructor.newInstance();

                        objInstance.setId(id);

                        return objInstance;
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.toList());
    }
}
