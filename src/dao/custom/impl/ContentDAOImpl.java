package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.ContentDAO;
import entity.Content;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContentDAOImpl implements ContentDAO {
    public List<Content> findAll() throws SQLException {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Content");
        ArrayList<Content> contents = new ArrayList<>();
        while (resultSet.next()){
            contents.add(new Content(resultSet.getString(1),resultSet.getString(2),resultSet.getDate(3),resultSet.getString(4),resultSet.getString(5)));
        }
        return contents;
    }

    public Content find(String pk) throws SQLException {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Content WHERE id=?",pk);
        if(resultSet.next()){
            return new Content(resultSet.getString(1),resultSet.getString(2),resultSet.getDate(3),resultSet.getString(4),resultSet.getString(5));
        }
        return null;
    }

    public boolean save(Content entity) throws SQLException {
        boolean result= CrudUtil.execute("INSERT INTO Content VALUES(?,?,?,?,?)", entity.getId(), entity.getTitle(), entity.getDate(), entity.getLecturerID(), entity.getModuleId());
        if(!result){
            return false;
        }
        return true;
    }

    public boolean update(Content entity) throws SQLException {
        boolean result = CrudUtil.execute("UPDATE CONTENT SET title=?,date=?,lecturerID=?,moduleId=? WHERE id=?", entity.getTitle(), entity.getDate(), entity.getLecturerID(), entity.getModuleId(), entity.getId());
        if(!result){
            return false;
        }
        return true;
    }

    public boolean delete(String pk) throws SQLException {
        boolean result = CrudUtil.execute("DELETE FROM Content WHERE id=?", pk);
        if(!result){
            return false;
        }
        return true;
    }

}
