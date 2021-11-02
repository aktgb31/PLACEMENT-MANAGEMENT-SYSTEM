package database;

import app.*;

import java.sql.*;
import java.util.ArrayList;

public class Operations {

    public static int addStudent(Student studentDetails) {
        try {
            Connection conn = Dao.getConnection();
            PreparedStatement statement = conn.prepareStatement("INSERT INTO students VALUES (?,?,?,?,?,?,?,?)");
            statement.setString(1, studentDetails.getRegisterNo());
            statement.setString(2, studentDetails.getName());
            statement.setString(3, studentDetails.getEmail());
            statement.setString(4, studentDetails.getPassword());
            statement.setFloat(5, studentDetails.getCgpa());
            statement.setString(6, studentDetails.getPhoneNo());
            statement.setString(7, studentDetails.getPlacementStatus());
            statement.setString(8, studentDetails.getPlacedIn());
            statement.executeUpdate();
            conn.close();
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    public static int updateStudent(Student studentDetails) {
        try {
            Connection conn = Dao.getConnection();
            PreparedStatement statement = conn.prepareStatement("UPDATE students SET Name=?,Email=?,Password=?, Cgpa=?, PhoneNo=?,PlacementStatus=?,PlacedIn=? WHERE RegisterNo=?" );
            statement.setString(1, studentDetails.getName());
            statement.setString(2, studentDetails.getEmail());
            statement.setString(3, studentDetails.getPassword());
            statement.setFloat(4, studentDetails.getCgpa());
            statement.setString(5, studentDetails.getPhoneNo());
            statement.setString(6, studentDetails.getPlacementStatus());
            statement.setString(7, studentDetails.getPlacedIn());
            statement.setString(8,studentDetails.getRegisterNo());
            statement.executeUpdate();
            conn.close();
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    public static ArrayList<Student> getAllStudents() {
        String query = "SELECT RegisterNo,Name,Email,Cgpa,PhoneNo,PlacementStatus,PlacedIn FROM students;";
        try {
            Connection conn = Dao.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultset = statement.executeQuery(query);
            ArrayList<Student> answer = new ArrayList<>();
            while (resultset.next()) {
                Student student = new Student();
                student.setRegisterNo(resultset.getString(1));
                student.setName(resultset.getString(2));
                student.setEmail(resultset.getString(3));
                student.setCgpa(resultset.getFloat(4));
                student.setPhoneNo(resultset.getString(5));
                student.setPlacementStatus(resultset.getString(6));
                student.setPlacedIn(resultset.getString(7));
                answer.add(student);
            }
            conn.close();
            return answer;
        } catch (Exception e) {
            System.out.println(e);
            return new ArrayList<>();
        }
    }

    public static int addRecruiter(Recruiter recruiterDetails) {
        try {
            Connection conn = Dao.getConnection();
            PreparedStatement statement = conn.prepareStatement("INSERT INTO recruiters VALUES (?,?,?,?,?,?)");
            statement.setInt(1, recruiterDetails.getRecruiterId());
            statement.setString(2, recruiterDetails.getName());
            statement.setString(3, recruiterDetails.getRole());
            statement.setString(4, recruiterDetails.getCtc());
            statement.setString(5, recruiterDetails.getDuration());
            statement.setString(6, recruiterDetails.getLocation());
            statement.executeUpdate();
            conn.close();
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    public static ArrayList<Recruiter> getAllRecruiters() {
        String query = "SELECT * FROM recruiters;";
        try {
            Connection conn = Dao.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultset = statement.executeQuery(query);
            ArrayList<Recruiter> answer = new ArrayList<>();
            while (resultset.next()) {
                Recruiter recruiter = new Recruiter();
                recruiter.setRecruiterId(resultset.getInt(1));
                recruiter.setName(resultset.getString(2));
                recruiter.setRole(resultset.getString(3));
                recruiter.setCtc(resultset.getString(4));
                recruiter.setDuration(resultset.getString(5));
                recruiter.setLocation(resultset.getString(6));
                answer.add(recruiter);
            }
            conn.close();
            return answer;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public static int removeRecruiter(Recruiter recruiter) {
        try {
            Connection conn = Dao.getConnection();
            PreparedStatement statement = conn.prepareStatement("DELETE FROM recruiters WHERE  recruiterId=?");
            statement.setInt(1, recruiter.getRecruiterId());
            statement.executeUpdate();
            conn.close();
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    public static int studentAppliesForCompany(Application application) {
        try {
            Connection conn = Dao.getConnection();
            PreparedStatement statement = conn.prepareStatement("INSERT INTO applications (studentId, recruiterId, status) VALUES(?,?,?) ");
            statement.setString(1, application.getStudentId());
            statement.setInt(2, application.getRecruiterId());
            statement.setString(3, application.getStatus());
            statement.executeUpdate();
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    public static int studentLogin(String registerNo,String password) {

        try {
            Connection connection = Dao.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM students WHERE RegisterNo=? and Password=? ");
            statement.setString(1, registerNo);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return 1;
            }
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
        return 0;
    }

    public static int placementOfficerLogin(int userId, String password) {
        try {
            Connection connection = Dao.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM placement_officer WHERE userId=? and password=? ");
            statement.setInt(1, userId);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return 1;
            }
            return 0;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }
}
