package dao.custom;

import dao.SuperDAO;
import entity.Course;

import java.sql.SQLException;
import java.util.List;

public interface QueryDAO extends SuperDAO {
    List<Course> findStudentCourses(String pk) throws Exception;
}
