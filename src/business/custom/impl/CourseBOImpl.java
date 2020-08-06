package business.custom.impl;

import business.custom.CourseBO;
import dao.DAOFactory;
import dao.DAOType;
import dao.custom.CourseDAO;
import entity.Course;
import util.CourseTM;

import java.util.ArrayList;
import java.util.List;

public class CourseBOImpl implements CourseBO {
    @Override
    public List<CourseTM> getAllCourses() throws Exception {
        try {
            CourseDAO courseDAO = DAOFactory.getInstance().getDAO(DAOType.COURSE);
            List<Course> allCourses = courseDAO.findAll();
            List<CourseTM> courses = new ArrayList<>();
            for (Course course : allCourses) {
                courses.add(new CourseTM(course.getId(),course.getTitle(),course.getType(),course.getDuration()));
            }
            return courses;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean saveCourseDetails(String id, String title, String type, double duration) throws Exception {
        try {
            CourseDAO courseDAO = DAOFactory.getInstance().getDAO(DAOType.COURSE);
            return courseDAO.save(new Course(id,title,type,duration));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteCourse(String id) throws Exception {
        try {
            CourseDAO courseDAO = DAOFactory.getInstance().getDAO(DAOType.COURSE);
            return courseDAO.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateCourse(String title, String type, double duration, String id) throws Exception {
        try {
            CourseDAO courseDAO = DAOFactory.getInstance().getDAO(DAOType.COURSE);
            return courseDAO.update(new Course(id, title, type,duration));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
