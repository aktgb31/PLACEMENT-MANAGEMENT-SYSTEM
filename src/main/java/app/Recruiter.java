package app;

public class Recruiter {
    private String name;
    private String role;
    private String ctc;

    public Recruiter(String name, String role, String ctc) {
        this.name = name;
        this.role = role;
        this.ctc = ctc;
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
}
