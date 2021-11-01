package app;

public class Recruiter {
    private int recruiterId;
    private String name;
    private String role;
    private String ctc;
    private String duration;
    private String location;

    public int getRecruiterId() {
        return recruiterId;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getCtc() {
        return ctc;
    }

    public String getDuration() {
        return duration;
    }

    public String getLocation() {
        return location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCtc(String ctc) {
        this.ctc = ctc;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setRecruiterId(int recruiterId) {
        this.recruiterId = recruiterId;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
