package business;

import business.custom.impl.*;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {
    }

    public static BOFactory getInstance(){
        return (boFactory==null)?boFactory=new BOFactory():boFactory;
    }

    public <T extends SuperBO> T getBO(BOType boType){
        switch(boType){
            case STUDENT:
                return (T) new StudentBOImpl();
            case MODULE:
                return (T) new ModuleBOImpl();
            case CONTENT:
                return (T) new ContentBOImpl();
            case COURSE:
                return (T) new CourseBOImpl();
            case ANNOUNCEMENT:
                return (T) new AnnouncementBOImpl();
            default:
                return null;
        }
    }
}
