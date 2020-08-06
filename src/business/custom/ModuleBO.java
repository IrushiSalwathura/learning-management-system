package business.custom;

import business.SuperBO;
import util.ModuleTM;

import java.util.List;

public interface ModuleBO extends SuperBO {
    public String getNewModuleId() throws Exception;
    public List<ModuleTM> getAllModules() throws Exception;
    public boolean saveModule(String id,String title,String duration, String credits,String courseId) throws Exception;
    public boolean deleteModule(String id)throws Exception;
    public boolean updateModule(String title,String duration, String credits,String courseId,String id)throws Exception;

}
