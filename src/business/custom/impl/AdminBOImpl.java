package business.custom.impl;

import business.custom.AdminBO;
import dao.DAOFactory;
import dao.DAOType;
import dao.custom.AdminDAO;
import entity.Admin;

import java.util.ArrayList;
import java.util.List;

public class AdminBOImpl implements AdminBO {
    private AdminDAO adminDAO = DAOFactory.getInstance().getDAO(DAOType.ADMIN);
    @Override
    public String getNewAdminId() throws Exception {
        String lastAdminId = adminDAO.getLastAdminId();
        if (lastAdminId == null){
            return "A001";
        }else{
            int maxId=  Integer.parseInt(lastAdminId.replace("A",""));
            maxId = maxId + 1;
            String id = "";
            if (maxId < 10) {
                id = "A00" + maxId;
            } else if (maxId < 100) {
                id = "A0" + maxId;
            } else {
                id = "A" + maxId;
            }
            return id;
        }
    }

    @Override
    public List<AdminTM> getAllAdmins() throws Exception {
        List<Admin> allAdmins = adminDAO.findAll();
        ArrayList<AdminTM> admins = new ArrayList<>();
        for (Admin admin : allAdmins) {
            admins.add(new AdminTM())
        }
    }

    @Override
    public boolean saveAdmin(String id, String name, String contact, String username, String password) throws Exception {
        return false;
    }

    @Override
    public boolean deleteAdmin(String id) throws Exception {
        return false;
    }

    @Override
    public boolean updateAdmin(String name, String contact, String username, String password) throws Exception {
        return false;
    }
}
