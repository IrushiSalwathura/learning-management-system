package business.custom;

import business.SuperBO;
import util.LectureTM;

import java.util.List;

public interface LecturerBO extends SuperBO {

    public List<LectureTM> getAllLecturers() throws Exception;

    public boolean saveLecturer(String id, String courseId, String name,String address, String contact,String username,String password,String nic,String email)throws Exception;

    public boolean deleteLecturer(String id)throws Exception;

    public boolean updateLecturer(String id, String courseId, String name,String address, String contact,String username,String password,String nic,String email)throws Exception;

    public String getNewLecturerId()throws Exception;
}
