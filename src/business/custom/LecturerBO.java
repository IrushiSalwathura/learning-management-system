package business.custom;

import business.SuperBO;
import util.AnnouncementTM;
import util.CourseTM;
import util.FacultyTM;
import util.LectureTM;

import java.util.List;

public interface LecturerBO extends SuperBO {

    List<LectureTM> getAllLecturers() throws Exception;

    boolean saveLecturer(String id, String courseId, String name,String address, String contact,String username,String password,String nic,String email)throws Exception;

    boolean deleteLecturer(String id)throws Exception;

    boolean updateLecturer(String courseId, String name,String address, String contact,String username,String password,String nic,String email,String id)throws Exception;

    String getNewLecturerId()throws Exception;

    List<FacultyTM> getLecturerFaculties(String lecturerId) throws Exception;

    List<CourseTM> getLecturerFacultyCourses(String lecturerId, String facultyId) throws Exception;

    List<AnnouncementTM> getAnnouncements(String courseId) throws Exception;

    LectureTM getLecturer(String id)throws Exception;
}
