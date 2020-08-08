package dao.custom;

import dao.SuperDAO;
import entity.Announcement;
import entity.Course;
import entity.CustomEntity;

import java.sql.SQLException;
import java.util.List;

public interface QueryDAO extends SuperDAO {
    List<Course> findStudentCourses(String pk) throws Exception;
    CustomEntity getCourseDetails(String studentId, String courseId) throws Exception;
    List<CustomEntity> getAnnouncements(String courseId) throws Exception;
}
