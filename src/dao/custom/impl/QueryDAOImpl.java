package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.QueryDAO;
import entity.Course;
import entity.Module;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QueryDAOImpl implements QueryDAO {

    public List<Course> findStudentCourses(String pk) throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT C.id,C.title,C.type,C.duration FROM StudentCourse S INNER JOIN Course C on S.courseId = C.id WHERE S.studentId=?", pk);
        ArrayList<Course> studentCourses = new ArrayList<>();
        while(resultSet.next()){
            studentCourses.add(new Course(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4)));
        }
        return studentCourses;
    }
}
