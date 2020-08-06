package business.custom;

import util.CourseTM;

import java.util.List;

public interface CourseBO {
    List<CourseTM> getAllCourses() throws Exception;
    boolean saveCourseDetails(String id, String title, String type, double duration) throws Exception;
    boolean deleteCourse(String id) throws Exception;
    boolean updateCourse(String title, String type, double duration, String id) throws Exception;
}
