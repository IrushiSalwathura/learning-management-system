package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.StudentDAO;
import entity.Module;
import entity.Student;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public List<Student> findAll() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM Student");
        ArrayList<Student> students = new ArrayList<>();
        while (rst.next()){
            students.add( new Student(rst.getString(1), rst.getString(2),
                    rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6),rst.getString(7),rst.getString(8),rst.getString(9)));
        }
        return students;
    }

    @Override
    public Student find(String key) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM Student WHERE id =?",key);
        if (rst.next()){
            return new Student(rst.getString(1), rst.getString(2),
                    rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6),rst.getString(7),rst.getString(8),rst.getString(9));
        }
        return null;
    }

    @Override
    public boolean save(Student student) throws Exception {
        return CrudUtil.execute("INSERT INTO Student VALUES (?,?,?,?,?,?,?,?,?)",
                student.getId(),student.getFacultyId(),student.getName(),student.getAddress(),student.getContact(),student.getUsername(),student.getPassword(),student.getNic(),student.getEmail());
    }

    @Override
    public boolean update(Student student) throws Exception {
        return CrudUtil.execute("UPDATE Student SET facultyId=?, name=?,address=?,contact=?,username=?,password=?,nic=?,email=? WHERE id=?",
                student.getFacultyId(),student.getName(),student.getAddress(),student.getContact(),student.getUsername(),student.getPassword(),student.getNic(),student.getEmail(),student.getId());
    }

    @Override
    public boolean delete(String key) throws Exception {
        return CrudUtil.execute("DELETE FROM Student WHERE id=?", key);
    }

    @Override
    public String getLastStudentId() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM Student ORDER BY id DESC  LIMIT 1");
        if (rst.next()){
            return rst.getString(1);
        }else{
            return null;
        }
    }

    public String getStudentCount() throws Exception{
        ResultSet rst = CrudUtil.execute("SELECT COUNT(*) AS Total FROM Student");
        if (rst.next()){
            return rst.getString(1);
        }else{
            return null;
        }
    }
}
