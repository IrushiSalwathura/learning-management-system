package entity;

public class FacultyLecturer {
    private FacultyLecturerPK facultyLecturerPK;

    public FacultyLecturer() {
    }

    public FacultyLecturer(FacultyLecturerPK facultyLecturerPK) {
        this.facultyLecturerPK = facultyLecturerPK;
    }

    public FacultyLecturerPK getFacultyLecturerPK() {
        return facultyLecturerPK;
    }

    public void setFacultyLecturerPK(FacultyLecturerPK facultyLecturerPK) {
        this.facultyLecturerPK = facultyLecturerPK;
    }
}
