package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;

import db.DBConnection;
import model.Comment;
import model.Course;

/*进行数据库操作*/

public class CommentDao {
    public static int count = 1000;

    public int save(Comment Comment) {
        //向数据库中插入一个用户的方法
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        con = DBConnection.getDBConnection();
        int row = 0;
        String sql = "insert into Comment(Comment_Content, Comment_Time, Comment_To, Chapter_Chapter_id, User_User_id) values(?,?,?,?,?)";
        try {
            count ++;
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, Comment.getComment_Content());
            pstmt.setTimestamp(2, Comment.getComment_Time());
            pstmt.setInt(3, Comment.getComment_To());
            pstmt.setInt(4, Comment.getChapter_Chapter_id());
            pstmt.setInt(5, Comment.getUser_User_id());
            row = pstmt.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            DBConnection.closeDB(con, pstmt, rs);
        }
        return row;
    }

    public Comment find(int Comment_id) {
        //从数据库中查找一个用户，用于验证是否注册
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        con = DBConnection.getDBConnection();
        Comment Comment2 = null;
        String sql = "select * from Comment where Comment_id=?";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, Comment_id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                Comment2 = new Comment();
                Comment2.setComment_id(rs.getInt("Comment_id"));
                Comment2.setComment_Content(rs.getString("Comment_Content"));
                Comment2.setComment_Time(rs.getTimestamp("Comment_Time"));
                Comment2.setComment_To(rs.getInt("Comment_To"));
                Comment2.setChapter_Chapter_id(rs.getInt("Chapter_Chapter_id"));
                Comment2.setUser_User_id(rs.getInt("User_User_id"));
            }
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            DBConnection.closeDB(con, pstmt, rs);
        }
        return Comment2;
    }

    public ArrayList<Comment> getChapterComment(int chapter_id) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        con = DBConnection.getDBConnection();
        String sql = "select * from comment where Chapter_Chapter_id = ? order by Comment_Time";
        ArrayList<Comment> CommentArrayList = new ArrayList<Comment>();
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, chapter_id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Comment Comment3 = new Comment();
                Comment3.setComment_id(rs.getInt("Comment_Id"));
                Comment3.setComment_Content(rs.getString("Comment_Content"));
                Comment3.setComment_To(rs.getInt("Comment_To"));
                Comment3.setChapter_Chapter_id(rs.getInt("Chapter_Chapter_id"));
                Comment3.setUser_User_id(rs.getInt("User_User_id"));
                Comment3.setComment_Time(rs.getTimestamp("Comment_Time"));
                CommentArrayList.add(Comment3);// 把一个商品加入集合
            }
            return CommentArrayList; // 返回集合。
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

    public ArrayList<Comment> getCommentReply(int comment_id) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        con = DBConnection.getDBConnection();
        String sql = "select * from comment where Comment_To = ? order by Comment_Time";
        ArrayList<Comment> CommentArrayList = new ArrayList<Comment>();
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, comment_id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Comment Comment3 = new Comment();
                Comment3.setComment_id(rs.getInt("Comment_Id"));
                Comment3.setComment_Content(rs.getString("Comment_Content"));
                Comment3.setComment_To(rs.getInt("Comment_To"));
                Comment3.setChapter_Chapter_id(rs.getInt("Chapter_Chapter_id"));
                Comment3.setUser_User_id(rs.getInt("User_User_id"));
                Comment3.setComment_Time(rs.getTimestamp("Comment_Time"));
                CommentArrayList.add(Comment3);// 把一个商品加入集合
            }
            return CommentArrayList; // 返回集合。
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


