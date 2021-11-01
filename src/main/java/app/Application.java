package app;

public class Application {
    private int applicationId;
    private String studentId;
    private int recruiterId;
    private String status;

    public void setRecruiterId(int recruiterId) {
        this.recruiterId = recruiterId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public String getStudentId() {
        return studentId;
    }

    public int getRecruiterId() {
        return recruiterId;
    }

    public String getStatus() {
        return status;
    }
}
