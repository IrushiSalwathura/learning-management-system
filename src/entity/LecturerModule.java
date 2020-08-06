package entity;

public class LecturerModule {
    private LecturerModulePK lecturerModulePK;

    public LecturerModule() {
    }

    public LecturerModule(LecturerModulePK lecturerModulePK) {
        this.lecturerModulePK = lecturerModulePK;
    }

    public LecturerModulePK getLecturerModulePK() {
        return lecturerModulePK;
    }

    public void setLecturerModulePK(LecturerModulePK lecturerModulePK) {
        this.lecturerModulePK = lecturerModulePK;
    }
}
