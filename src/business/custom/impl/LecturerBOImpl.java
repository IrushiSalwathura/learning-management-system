package business.custom.impl;

import business.custom.LecturerBO;
import dao.CrudUtil;
import dao.DAOFactory;
import dao.DAOType;
import dao.SuperDAO;
import dao.custom.*;
import entity.*;
import util.CourseTM;
import util.FacultyTM;
import util.LectureTM;
import util.ModuleTM;

import java.sql.SQLException;
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

    public List<FacultyTM> getLecturerFaculties(String lecturerId) throws Exception {
        QueryDAO queryDAO = DAOFactory.getInstance().getDAO(DAOType.QUERY);
        List<Faculty> lecturerFaculties = queryDAO.findLecturerFaculties(lecturerId);
        ArrayList<FacultyTM> facultyTMS = new ArrayList<>();

        for (Faculty faculty : lecturerFaculties) {
            facultyTMS.add(new FacultyTM(faculty.getId(),faculty.getName(),faculty.getAddress()));
        }
        return facultyTMS;
    }

    public List<CourseTM> getLecturerFacultyCourses(String lecturerId, String facultyId) throws Exception {
        QueryDAO queryDAO = DAOFactory.getInstance().getDAO(DAOType.QUERY);
        List<Course> lecturerFacultyCourses = queryDAO.findLecturerFacultyCourses(lecturerId,facultyId);
        ArrayList<CourseTM> courseTMS = new ArrayList<>();

        for (Course course : lecturerFacultyCourses) {
            courseTMS.add(new CourseTM(course.getId(),course.getTitle(),course.getType(),course.getDuration()));
        }
        return courseTMS;
    }

    public List<ModuleTM> getCourseModules(String courseId) throws Exception {
        ModuleDAO moduleDAO = DAOFactory.getInstance().getDAO(DAOType.MODULE);
        List<Module> courseModules = moduleDAO.getCourseModules(courseId);
        ArrayList<ModuleTM> moduleTMS = new ArrayList<>();

        for (Module module : courseModules) {
            moduleTMS.add(new ModuleTM(module.getId(),module.getTitle(),module.getDuration(),module.getCredits(),module.getCourseId()));
        }
        return moduleTMS;
    }

    @Override
    public LectureTM getLecturer(String id) throws Exception {
        LecturerDAO lecturerDAO = DAOFactory.getInstance().getDAO(DAOType.LECTURER);
        Lecturer lectureDetails=lecturerDAO.find(id);
        return new LectureTM(lectureDetails.getId(),lectureDetails.getCourseId(),lectureDetails.getName(),lectureDetails.getAddress(),lectureDetails.getContact(),
                lectureDetails.getUsername(),lectureDetails.getPassword(),lectureDetails.getNic(),lectureDetails.getEmail());
    }
}
