package entity;

import java.io.Serializable;

public class Lecturer implements Serializable {

    private String id;
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

    public Lecturer(String id, String courseId, String name, String address, String contact, String username, String password, String nic, String email) {
        this.id = id;
        this.courseId = courseId;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.username = username;
        this.password = password;
        this.nic = nic;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
                "id='" + id + '\'' +
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
