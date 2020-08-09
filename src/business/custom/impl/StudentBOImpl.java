package business.custom.impl;

import business.custom.StudentBO;
import dao.DAOFactory;
import dao.DAOType;
import dao.SuperDAO;
import dao.custom.LecturerDAO;
import dao.custom.QueryDAO;
import dao.custom.StudentDAO;
import entity.Course;
import entity.CustomEntity;
import entity.Lecturer;
import entity.Student;
import util.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentBOImpl implements StudentBO {
    private StudentDAO studentDAO = DAOFactory.getInstance().getDAO(DAOType.STUDENT);

    @Override
    public String getNewStudentId() throws Exception {
        String lastStudentId = studentDAO.getLastStudentId();
        if (lastStudentId == null){
            return "S001";
        }else{
            int maxId=  Integer.parseInt(lastStudentId.replace("S",""));
            maxId = maxId + 1;
            String id = "";
            if (maxId < 10) {
                id = "S00" + maxId;
            } else if (maxId < 100) {
                id = "S0" + maxId;
            } else {
                id = "S" + maxId;
            }
            return id;
        }
    }

    @Override
    public List<StudentTM> getAllStudents() throws Exception {
        List<Student> allStudents = studentDAO.findAll();
        List<StudentTM> students = new ArrayList<>();
        for (Student student : allStudents) {
            students.add(new StudentTM(student.getId(),student.getFacultyId(),student.getName(),student.getAddress(),
                    student.getContact(),student.getUsername(),student.getPassword(),student.getNic(),student.getEmail()));
        }
        return students;
    }

    @Override
    public boolean saveStudent(String id, String facultyId, String name, String address, String contact, String username, String password, String nic, String email) throws Exception {
        return studentDAO.save(new Student(id,facultyId,name,address,contact,username,password,nic,email));

    }

    @Override
    public boolean deleteStudent(String id) throws Exception {
        return studentDAO.delete(id);

    }

    @Override
    public boolean updateStudent(String facultyId, String name, String address, String contact, String username, String password, String nic, String email, String id) throws Exception {
        return studentDAO.update(new Student(id,facultyId,name, address,contact,username,password,nic,email));

    }

    public List<CourseTM> getStudentCourses(String studentId) throws Exception {
        QueryDAO queryDAO= DAOFactory.getInstance().getDAO(DAOType.QUERY);
        List<Course> studentCourses = queryDAO.findStudentCourses(studentId);
        ArrayList<CourseTM> courses = new ArrayList<>();

        for (Course course : studentCourses) {
            courses.add(new CourseTM(course.getId(),course.getTitle(),course.getType(),course.getDuration()));
        }
        return courses;
    }

    public CourseTM getCourseDetails(String studentId, String courseId) throws Exception{
            QueryDAO queryDAO = DAOFactory.getInstance().getDAO(DAOType.QUERY);
            CustomEntity courseDetails =  queryDAO.getStudentCourseDetails(studentId,courseId);
            return new CourseTM(courseDetails.getTitle(),courseDetails.getType());
    }

    public List<AnnouncementTM> getAnnouncements(String courseId) throws Exception {
        QueryDAO queryDAO= DAOFactory.getInstance().getDAO(DAOType.QUERY);
        List<CustomEntity> announcements = queryDAO.getAnnouncements(courseId);
        ArrayList<AnnouncementTM> announcement = new ArrayList<>();

        for (CustomEntity ann : announcements) {
            announcement.add(new AnnouncementTM(ann.getCourseId(),ann.getLecturerId(),ann.getDate(),ann.getAnnouncement()));
        }
        return announcement;
    }

    @Override
    public StudentTM getStudent(String id) throws Exception {
        StudentDAO studentDAO = DAOFactory.getInstance().getDAO(DAOType.STUDENT);
        Student studentDetails=studentDAO.find(id);
        return new StudentTM(studentDetails.getId(),studentDetails.getFacultyId(),studentDetails.getName(),studentDetails.getAddress(),
                studentDetails.getContact(), studentDetails.getUsername(),studentDetails.getPassword(),
                studentDetails.getNic(),studentDetails.getEmail());
    }

    public String getStudentCount() throws Exception {
        StudentDAO studentDAO = DAOFactory.getInstance().getDAO(DAOType.STUDENT);
        String studentTotal = studentDAO.getStudentCount();
        return studentTotal;
    }



}
