package dao.custom;

import dao.CrudDAO;
import entity.Admin;

public interface AdminDAO extends CrudDAO<Admin,String> {
    public String getLastAdminId() throws Exception;
    public String getUserId(String pk) throws Exception;

}
