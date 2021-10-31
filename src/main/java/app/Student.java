package app;

public class Student {
    private String name;
    private String registerNo;
    private String email;
    private String phoneNo;
    private float cgpa;
    private String placementStatus;

    public Student(String name, String registerNo, String email, String phoneNo, float cgpa, String placementStatus) {
        this.name = name;
        this.registerNo = registerNo;
        this.email = email;
        this.phoneNo = phoneNo;
        this.cgpa = cgpa;
        this.placementStatus = placementStatus;
    }

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
}
