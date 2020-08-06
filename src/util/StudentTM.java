package util;

public class StudentTM {
    private String id;
    private String facultyId;
    private String name;
    private String address;
    private String contact;
    private String username;
    private String password;
    private String nic;
    private String email;

    public StudentTM() {
    }

    public StudentTM(String id, String facultyId, String name, String address, String contact, String username, String password, String nic, String email) {
        this.id = id;
        this.facultyId = facultyId;
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

    public String getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(String facultyId) {
        this.facultyId = facultyId;
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

    @Override
    public String toString() {
        return "StudentTM{" +
                "id='" + id + '\'' +
                ", facultyId='" + facultyId + '\'' +
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
