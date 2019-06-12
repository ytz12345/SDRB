package dao;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

import db.DBConnection;
import model.Course;
import model.user_has_course;

/*进行数据库操作*/

public class user_has_courseDao {
    public static int count = 1000;

    public List<Course> courseList;
    public List<Course> courseList1 =new ArrayList<Course>();

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public int save(user_has_course user_has_course) {
        //向数据库中插入一个用户的方法
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        con = DBConnection.getDBConnection();
        int row = 0;
        String sql = "insert into user_has_course(User_User_id,Course_Course_Id, User_Teachorstudy) values(?,?,?)";
        try {
            count ++;
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, user_has_course.getCourse_Course_Id());
            pstmt.setInt(2, user_has_course.getCourse_Course_Id());
            pstmt.setInt(3, user_has_course.getUser_Teachorstudy());
            row = pstmt.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            DBConnection.closeDB(con, pstmt, rs);
        }
        return row;
    }

    public user_has_course find(user_has_course user_has_course) {
        //从数据库中查找一个用户，用于验证是否注册
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        con = DBConnection.getDBConnection();
        user_has_course user_has_course2 = null;
        String sql = "select * from user_has_course where User_User_id=? and Course_Course_Id=?";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, user_has_course.getCourse_Course_Id());
            pstmt.setInt(2, user_has_course.getUser_User_id());
            rs = pstmt.executeQuery();
            if (rs.next()) {
                user_has_course2 = new user_has_course();
                user_has_course2.setCourse_Course_Id(rs.getInt("Course_Course_Id"));
                user_has_course2.setUser_User_id(rs.getInt("User_User_id"));
                user_has_course2.setUser_Teachorstudy(rs.getInt("User_Teachorstudy"));
            }
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            DBConnection.closeDB(con, pstmt, rs);
        }
        return user_has_course2;
    }

    public int CountNumber(user_has_course user_has_course){
        //从数据库查找指定用户选择的课程数量
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int num = 0;
        con = DBConnection.getDBConnection();
        String sql = "SELECT COUNT(Course_Course_Id) FROM user_has_course WHERE User_User_id=? and User_Teachorstudy=1";
        try{
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, user_has_course.getUser_User_id());
            rs = pstmt.executeQuery();
            if (rs.next()) {
                num = rs.getInt(1);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            DBConnection.closeDB(con, pstmt, rs);
        }
        return num;
    }

    public String FindCourseIds(int u2_id){
        //从数据库查找指定用户的课程并返回课程ID数组
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Course temp_course = null;
        String forward = null;
        con = DBConnection.getDBConnection();
        String sql = "SELECT course.* FROM user_has_course,course WHERE User_User_id =? and user_has_course.Course_Course_Id=course.Course_Id and User_Teachorstudy=1";
        try{
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, u2_id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                temp_course = new Course();
                temp_course.setCourse_Id(rs.getInt("Course_Id"));
                temp_course.setCourse_Name(rs.getString("Course_Name"));
                temp_course.setCourse_Pass(rs.getInt("Course_Pass"));
                temp_course.setCourse_Intro(rs.getString("Course_Intro"));
                temp_course.setCourse_Image(rs.getString("Course_Image"));
                temp_course.setCourse_Date(rs.getDate("Course_Date"));
                temp_course.setCourse_Teacher(rs.getString("Course_Teacher"));
                courseList1.add(temp_course);
            }
            forward = "success";
            System.out.println("success");
        }catch(Exception e) {
            forward = "failure";
            e.printStackTrace();
        }finally {
            DBConnection.closeDB(con, pstmt, rs);
        }
        System.out.println("printing user courseList ... ");
        this.setCourseList(courseList1);
        System.out.println(courseList);
        return forward;
    }
}


