package business.custom;

import business.SuperBO;
import util.AdminTM;
import util.StudentTM;

import java.util.List;

public interface StudentBO extends SuperBO {
    public String getNewStudentId() throws Exception;
    public List<StudentTM> getAllStudents() throws Exception;
    public boolean saveStudent(String id,String facultyId, String name,String address, String contact,String username, String password,String nic, String email) throws Exception;
    public boolean deleteStudent(String id)throws Exception;
    public boolean updateStudent(String facultyId, String name,String address, String contact,String username, String password,String nic, String email,String id)throws Exception;
}
