package business;

import business.custom.impl.ContentBOImpl;
import business.custom.impl.ModuleBOImpl;
import business.custom.impl.StudentBOImpl;

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
                default:
                return null;
        }
    }
}
