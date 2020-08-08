package dao.custom.impl;


import dao.CrudUtil;
import dao.custom.LecturerDAO;
import entity.Lecturer;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LecturerDAOImpl implements LecturerDAO {

    @Override
    public String getLastLecturerId() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT id FROM Lecturer ORDER BY id DESC LIMIT 1");
        if (rst.next()) {
            return rst.getString(1);
        } else {
            return null;
        }
    }

    @Override
    public List<Lecturer> findAll() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM Lecturer");
        List<Lecturer> lecturers = new ArrayList<>();
        while (rst.next()) {
            lecturers.add(new Lecturer(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8),
                    rst.getString(9)));
        }
        return lecturers;
    }

    @Override
    public Lecturer find(String key) throws Exception {

        ResultSet rst = CrudUtil.execute("SELECT * FROM Lecturer WHERE id=?", key);
        if (rst.next()) {
            return new Lecturer(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8),
                    rst.getString(9)
            );
        }
        return null;
    }

    @Override
    public boolean delete(String key) throws Exception {
        return CrudUtil.execute("DELETE FROM Lecturer WHERE id=?",key);
    }

    @Override
    public boolean update(Lecturer lecturer) throws Exception {
        return CrudUtil.execute("UPDATE Lecturer SET courseId=?, name=?,address=?,contact=?,username=?,password=?,nic=?,email=? WHERE id=?",
                lecturer.getCourseId(),lecturer.getName(),lecturer.getAddress(),lecturer.getContact(),lecturer.getUsername(),lecturer.getPassword(),lecturer.getNic(),lecturer.getEmail(),lecturer.getId());
    }

    @Override
    public boolean save(Lecturer lecturer) throws Exception {
        return CrudUtil.execute("INSERT INTO Lecturer VALUES (?,?,?,?,?,?,?,?,?)",lecturer.getId(),lecturer.getCourseId(),
                lecturer.getName(),lecturer.getAddress(),lecturer.getContact(),lecturer.getUsername(),lecturer.getPassword(),lecturer.getNic(),lecturer.getEmail());

    }


}

