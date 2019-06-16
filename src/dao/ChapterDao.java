package dao;

import java.sql.*;
import java.util.ArrayList;

import conn.DBConnection;
import model.Chapter;

/*进行数据库操作*/

public class ChapterDao {

    public int save(Chapter Chapter, String videoUrl, int course_id) {
        //向数据库中插入一个用户的方法
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        con = DBConnection.getDBConnection();
        int row = 0;
        String sql = "insert into Chapter(Chapter_Name, Chapter_Video, Course_Course_Id, Chapter_Num) values(?,?,?,?)";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, Chapter.getChapter_Name());
            pstmt.setString(2, videoUrl);
            pstmt.setInt(3, course_id);
            pstmt.setInt(4, Chapter.getChapter_Num());
            row = pstmt.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            DBConnection.closeDB(con, pstmt, rs);
        }
        return row;
    }

    public Chapter findChapter(int Chapter_id) {
        //从数据库中查找一个用户，用于验证是否注册
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        con = DBConnection.getDBConnection();
        Chapter Chapter2 = null;
        String sql = "select * from Chapter where Chapter_id=?";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, Chapter_id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                Chapter2 = new Chapter();
                Chapter2.setChapter_id(rs.getInt("Chapter_id"));
                Chapter2.setChapter_Num(rs.getInt("Chapter_Num"));
                Chapter2.setChapter_Name(rs.getString("Chapter_Name"));
                Chapter2.setChapter_Video(rs.getString("Chapter_Video"));
                Chapter2.setChapter_PPT(rs.getString("Chapter_PPT"));
                Chapter2.setCourse_Course_Id(rs.getInt("Course_Course_Id"));
            }
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            DBConnection.closeDB(con, pstmt, rs);
        }
        return Chapter2;
    }

    public ArrayList<Chapter> getSpecifcChapter(int course_id) {    //获得制定课程的所有章节
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        con = DBConnection.getDBConnection();
        String sql = "select * from Chapter where Course_Course_Id = ? order by Chapter_Num";
        ArrayList<Chapter> ChapterArrayList = new ArrayList<Chapter>();
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, course_id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Chapter Chapter3 = new Chapter();
                Chapter3.setChapter_id(rs.getInt("Chapter_Id"));
                Chapter3.setChapter_Name(rs.getString("Chapter_Name"));
                Chapter3.setChapter_Num(rs.getInt("Chapter_Num"));
                Chapter3.setChapter_PPT(rs.getString("Chapter_PPT"));
                Chapter3.setChapter_Video(rs.getString("Chapter_Video"));
                Chapter3.setChapter_Intro(rs.getString("Chapter_Intro"));
                Chapter3.setCourse_Course_Id(rs.getInt("Course_Course_Id"));
                ChapterArrayList.add(Chapter3);// 把一个商品加入集合
            }
            return ChapterArrayList; // 返回集合。
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            // 释放数据集对象
            if (rs != null) {
                try {
                    rs.close();
                    rs = null;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            // 释放语句对象
            if (pstmt != null) {
                try {
                    pstmt.close();
                    pstmt = null;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}


