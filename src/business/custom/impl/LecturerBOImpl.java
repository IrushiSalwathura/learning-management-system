package business.custom.impl;

import business.custom.LecturerBO;
import dao.CrudUtil;
import dao.DAOFactory;
import dao.DAOType;
import dao.SuperDAO;
import dao.custom.CourseDAO;
import dao.custom.LecturerDAO;
import dao.custom.StudentCourseDAO;
import entity.Course;
import entity.Lecturer;
import entity.Student;
import entity.StudentCourse;
import util.CourseTM;
import util.LectureTM;

import java.util.ArrayList;
import java.util.List;

public class LecturerBOImpl implements LecturerBO {
    // Field Injection
    private LecturerDAO lecturerDAO = DAOFactory.getInstance().getDAO(DAOType.LECTURER);

    @Override
    public List<LectureTM> getAllLecturers() throws Exception {

        List<Lecturer>allLecturers = lecturerDAO.findAll();
        List<LectureTM>lectures = new ArrayList<>();
        for (Lecturer lecturer:allLecturers) {
            lectures.add(new LectureTM(lecturer.getId(),
                    lecturer.getCourseId(),lecturer.getName(),
                    lecturer.getAddress(),lecturer.getContact(),
                    lecturer.getUsername(),lecturer.getPassword(),
                    lecturer.getNic(),lecturer.getEmail()));
        }
        return lectures;
    }

    @Override
    public boolean saveLecturer(String id, String courseId, String name, String address, String contact, String username, String password, String nic, String email) throws Exception {
        return lecturerDAO.save(new Lecturer(id,courseId,name,address,contact,username,password,nic,email));

    }

    @Override
    public boolean deleteLecturer(String id) throws Exception {
        return lecturerDAO.delete(id);
    }

    @Override
    public boolean updateLecturer(String courseId, String name, String address, String contact, String username, String password, String nic, String email, String id) throws Exception {
        return lecturerDAO.update(new Lecturer(id,courseId,name, address,contact,username,password,nic,email));
    }

    @Override
    public String getNewLecturerId() throws Exception {
        try {
            String lastLecturerId = lecturerDAO.getLastLecturerId();
            if (lastLecturerId == null) {
                return "L001";
            } else {
                int maxId = Integer.parseInt(lastLecturerId.replace("L", ""));
                maxId = maxId + 1;
                String id = "";
                if (maxId < 10) {
                    id = "L00" + maxId;
                } else if (maxId < 100) {
                    id = "L0" + maxId;
                } else {
                    id = "L" + maxId;
                }
                return id;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
