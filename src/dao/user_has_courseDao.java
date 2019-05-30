package dao;

import java.sql.*;

import db.DBConnection;
import model.user_has_course;

/*进行数据库操作*/

public class user_has_courseDao {
    public static int count = 1000;

    public int save(user_has_course user_has_course) {
        //向数据库中插入一个用户的方法
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        con = DBConnection.getDBConnection();
        int row = 0;
        String sql = "insert into user_has_course(User_User_Name,Course_Course_Id) values(?,?)";
        try {
            count ++;
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, user_has_course.getUser_User_Name());
            pstmt.setInt(2, user_has_course.getCourse_Course_Id());
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
        String sql = "select * from user_has_course where User_User_Name=? and Course_Course_Id=?";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, user_has_course.getCourse_Course_Id());
            pstmt.setString(2, user_has_course.getUser_User_Name());
            rs = pstmt.executeQuery();
            if (rs.next()) {
                user_has_course2 = new user_has_course();
                user_has_course2.setCourse_Course_Id(rs.getInt("Course_Course_Id"));
                user_has_course2.setUser_User_Name(rs.getString("User_User_Name"));
            }
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            DBConnection.closeDB(con, pstmt, rs);
        }
        return user_has_course2;
    }

}


