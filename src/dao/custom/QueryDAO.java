package dao.custom;

import dao.SuperDAO;
import entity.Content;
import entity.Course;
import entity.Faculty;

import java.util.List;

public interface QueryDAO extends SuperDAO {
    List<Course> findStudentCourses(String pk) throws Exception;
    List<Faculty> findLecturerFaculties(String pk) throws Exception;
    List<Course> findLecturerFacultyCourses(String pk1, String pk2 ) throws Exception;
    List<Content> findModuleContent(String moduleId) throws Exception;
}
