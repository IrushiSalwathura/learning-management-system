package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.QueryDAO;
import entity.Course;

import entity.Module;

import entity.CustomEntity;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QueryDAOImpl implements QueryDAO {

    public List<Course> findStudentCourses(String pk) throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT C.id,C.title,C.type,C.duration FROM StudentCourse S\n" +
                "INNER JOIN Course C on S.courseId = C.id\n" +
                "WHERE S.studentId=?", pk);
        ArrayList<Course> studentCourses = new ArrayList<>();
        while(resultSet.next()){
            studentCourses.add(new Course(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4)));
        }
        return studentCourses;
    }

    @Override
    public CustomEntity getCourseDetails(String studentId, String courseId) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT C.title,C.type from StudentCourse sc INNER JOIN Course C on sc.courseId = C.id\n" +
                "WHERE studentId=? AND courseId=?", studentId,courseId);

        if (rst.next()) {
            return new CustomEntity(rst.getString(1), rst.getString(2));

        }
        return null;
    }

    @Override
    public List<CustomEntity> getAnnouncements(String courseId) throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT A.courseId,A.lecturerId,A.date,A.announcement\n" +
                "FROM Course C\n" +
                "INNER JOIN Announcement A on C.id = A.courseId\n" +
                "WHERE C.id =?", courseId);
        ArrayList<CustomEntity> announcements = new ArrayList<>();
        while(resultSet.next()){
            announcements.add(new CustomEntity(resultSet.getString(1),resultSet.getString(2),
                    resultSet.getDate(3),resultSet.getString(4)));
        }
        return announcements;
    }


}
