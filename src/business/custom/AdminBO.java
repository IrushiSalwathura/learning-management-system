package business.custom;

import business.SuperBO;

import java.util.List;

public interface AdminBO extends SuperBO {
    public String getNewAdminId() throws Exception;
    public List<AdminTM> getAllAdmins() throws Exception;
    public boolean saveAdmin(String id, String name, String contact,String username, String password) throws Exception;
    public boolean deleteAdmin(String id)throws Exception;
    public boolean updateAdmin(String name, String contact, String username, String password)throws Exception;
}
