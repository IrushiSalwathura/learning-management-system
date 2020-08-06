package entity;

import java.io.Serializable;

public class Lecturer implements Serializable {

    private String lecturerId;
    private String courseId;
    private String name;
    private String address;
    private String contact;
    private String username;
    private String password;
    private String nic;
    private String email;

    public Lecturer() {
    }

    public Lecturer(String lecturerId, String courseId, String name, String address, String contact, String username, String password, String nic, String email) {
        this.lecturerId = lecturerId;
        this.courseId = courseId;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.username = username;
        this.password = password;
        this.nic = nic;
        this.email = email;
    }

    public String getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(String lecturerId) {
        this.lecturerId = lecturerId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Lecturer{" +
                "lecturerId='" + lecturerId + '\'' +
                ", courseId='" + courseId + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nic='" + nic + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
