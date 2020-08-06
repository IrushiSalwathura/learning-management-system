package dao.custom;

import dao.CrudDAO;
import entity.Faculty;

public interface FacultyDAO extends CrudDAO<Faculty,String> {

    String getLastFacultyId() throws Exception;
}
