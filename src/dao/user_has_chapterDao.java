package dao;

import java.sql.*;

import db.DBConnection;
import model.user_has_chapter;

/*进行数据库操作*/

public class user_has_chapterDao {
    public static int count = 1000;

    public int save(user_has_chapter user_has_chapter) {
        //向数据库中插入一个用户的方法
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        con = DBConnection.getDBConnection();
        int row = 0;
        String sql = "insert into user_has_chapter(User_User_Name,Chapter_Chapter_id) values(?,?)";
        try {
            count ++;
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, user_has_chapter.getUser_User_Name());
            pstmt.setInt(2, user_has_chapter.getChapter_Chapter_id());
            row = pstmt.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            DBConnection.closeDB(con, pstmt, rs);
        }
        return row;
    }

    public user_has_chapter find(user_has_chapter user_has_chapter) {
        //从数据库中查找一个用户，用于验证是否注册
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        con = DBConnection.getDBConnection();
        user_has_chapter user_has_chapter2 = null;
        String sql = "select * from user_has_chapter where User_User_Name=? and Chapter_Chapter_id=?";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, user_has_chapter.getChapter_Chapter_id());
            pstmt.setString(2, user_has_chapter.getUser_User_Name());
            rs = pstmt.executeQuery();
            if (rs.next()) {
                user_has_chapter2 = new user_has_chapter();
                user_has_chapter2.setChapter_Chapter_id(rs.getInt("Chapter_Chapter_id"));
                user_has_chapter2.setUser_User_Name(rs.getString("User_User_Name"));
            }
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            DBConnection.closeDB(con, pstmt, rs);
        }
        return user_has_chapter2;
    }

}


