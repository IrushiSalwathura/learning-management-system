package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.QueryDAO;
import entity.Content;
import entity.Course;
import entity.Faculty;
import entity.Module;

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

    public List<Faculty> findLecturerFaculties(String pk) throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT F.id,F.name,F.address FROM Faculty F\n" +
                "INNER JOIN FacultyLecturer FL on F.id = FL.facultyId\n" +
                "WHERE lecturerId=?", pk);
        ArrayList<Faculty> lecturerFaculties = new ArrayList<>();

        while (resultSet.next()) {
            lecturerFaculties.add(new Faculty(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3)));
        }
        return lecturerFaculties;
    }

    public List<Course> findLecturerFacultyCourses(String pk1, String pk2 ) throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT C.id,C.title,C.type,C.duration FROM Course C\n" +
                "INNER JOIN Lecturer L on C.id = L.courseId\n" +
                "INNER JOIN FacultyLecturer FL on L.id = FL.lecturerId\n" +
                "WHERE lecturerId=? AND FL.facultyId=?", pk1,pk2);
        ArrayList<Course> courses = new ArrayList<>();
        while(resultSet.next()){
            courses.add(new Course(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4)));
        }
        return courses;
    }

    public List<Content> findModuleContent(String moduleId) throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT C.id,C.title,C.date,C.lecturerID,C.moduleId FROM Content C\n" +
                "INNER JOIN Module M on C.moduleId = M.id\n" +
                "WHERE moduleId=?", moduleId);
        ArrayList<Content> content = new ArrayList<>();
        while(resultSet.next()){
            content.add(new Content(resultSet.getString(1),resultSet.getString(2),resultSet.getDate(3),resultSet.getString(4),resultSet.getString(5)));
        }
        return content;
    }
}
