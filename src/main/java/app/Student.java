package app;

public class Student {
    private String name;
    private String registerNo;
    private String email;
    private String phoneNo;
    private float cgpa;
    private String placementStatus;
    private String placedIn;
    private String password;

    public String getName() {
        return name;
    }

    public String getRegisterNo() {
        return registerNo;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public float getCgpa() {
        return cgpa;
    }

    public String getPlacementStatus() {
        return placementStatus;
    }

    public String getPlacedIn() {
        return placedIn;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRegisterNo(String registerNo) {
        this.registerNo = registerNo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setCgpa(float cgpa) {
        this.cgpa = cgpa;
    }

    public void setPlacementStatus(String placementStatus) {
        this.placementStatus = placementStatus;
    }

    public void setPlacedIn(String placedIn) {
        this.placedIn = placedIn;
    }

    public String getPassword() {
        return password;
    }
}
