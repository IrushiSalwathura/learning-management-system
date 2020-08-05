package dao.custom;

import dao.CrudDAO;
import entity.Module;

public interface ModuleDAO extends CrudDAO<Module,String> {
    public String getLastModuleId() throws Exception;

}
