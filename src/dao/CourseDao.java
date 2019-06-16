package dao;

import java.sql.*;

import conn.DBConnection;
import model.Course;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*进行数据库操作*/

public class CourseDao {

    public int save(Course course, String imageUrl) {
        //向数据库中插入一个课程的方法
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        con = DBConnection.getDBConnection();
        int row = 0;
        String sql = "insert into Course(Course_Name, Course_Pass, Course_Intro, Course_Image, Course_Date, Course_Teacher) values(?,?,?,?,?,?)";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, course.getCourse_Name());
            pstmt.setInt(2, 0);
            pstmt.setString(3, course.getCourse_Intro());
            pstmt.setString(4, imageUrl);

            Date date = new Date();//获得系统时间.
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            pstmt.setDate(5, sqlDate);

            pstmt.setString(6, course.getCourse_Teacher());
            row = pstmt.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            DBConnection.closeDB(con, pstmt, rs);
        }
        return row;
    }

    public int teacherHasCourse(Course course, int teacher_id){
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        con = DBConnection.getDBConnection();
        int row = 0;
        String sql = "insert into user_has_course(Course_Course_Id, User_Teachorstudy, User_User_id) values(?,?,?)";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, course.getCourse_Id());
            pstmt.setInt(2, 1);
            pstmt.setInt(3, teacher_id);
            row = pstmt.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            DBConnection.closeDB(con, pstmt, rs);
        }
        return row;

    }

    public List<Course> displayCourses() {
        //用户登录Action方法
        List<Course> list1=new ArrayList<Course>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        con = DBConnection.getDBConnection();
        Course course2 = null;
        String sql = "select * from course";
        String forward = null;
        try {
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                course2 = new Course();
                course2.setCourse_Id(rs.getInt("Course_Id"));
                course2.setCourse_Name(rs.getString("Course_Name"));
                course2.setCourse_Teacher(rs.getString("Course_Teacher"));
                course2.setCourse_Pass(rs.getInt("Course_Pass"));
                course2.setCourse_Intro(rs.getString("Course_Intro"));
                list1.add(course2);
            }
            forward="success";
            System.out.println("success");
        }catch(Exception e) {
            forward = "failure";
            e.printStackTrace();
        }finally {
            DBConnection.closeDB(con, pstmt, rs);
        }
        //注入

        return list1;
    }

    public int modifyCourseImage(String newImage, int course_id){
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        con = DBConnection.getDBConnection();
        int row = 0;
        String sql = "update Course set Course_Image = ? where Course_Id = ?";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, newImage);
            pstmt.setInt(2, course_id);
            row = pstmt.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            DBConnection.closeDB(con, pstmt, rs);
        }
        return row;
    }

    public int modifyCourseName(String newCourseName, int course_id){
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        con = DBConnection.getDBConnection();
        int row = 0;
        String sql = "update Course set Course_Name = ? where Course_Id = ?";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, newCourseName);
            pstmt.setInt(2, course_id);
            row = pstmt.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            DBConnection.closeDB(con, pstmt, rs);
        }
        return row;
    }

    public int modifyCourseIntro(String newCourseIntro, int course_id){
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        con = DBConnection.getDBConnection();
        int row = 0;
        String sql = "update Course set Course_Intro = ? where Course_Id = ?";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, newCourseIntro);
            pstmt.setInt(2, course_id);
            row = pstmt.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            DBConnection.closeDB(con, pstmt, rs);
        }
        return row;
    }

    public int passCourse(int course_id){
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        con = DBConnection.getDBConnection();
        int row = 0;
        String sql = "update Course set Course_Pass = 1 where Course_Id = ?";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, course_id);
            row = pstmt.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            DBConnection.closeDB(con, pstmt, rs);
        }
        return row;
    }

    public int dontPassCourse(int course_id){
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        con = DBConnection.getDBConnection();
        int row = 0;
        String sql = "update Course set Course_Pass = 2 where Course_Id = ?";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, course_id);
            row = pstmt.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            DBConnection.closeDB(con, pstmt, rs);
        }
        return row;
    }

    public int deleteCourse(int course_id){
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        con = DBConnection.getDBConnection();
        int row = 0;
        String sql = "delete from Course where Course_Id = ?";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, course_id);
            row = pstmt.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            DBConnection.closeDB(con, pstmt, rs);
        }
        return row;
    }




    public Course find(int Course_Id) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        con = DBConnection.getDBConnection();
        Course Course2 = null;
        String sql = "select * from Course where Course_Id=?";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, Course_Id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                Course2 = new Course();
                Course2.setCourse_Id(rs.getInt("Course_Id"));
                Course2.setCourse_Name(rs.getString("Course_Name"));
                Course2.setCourse_Pass(rs.getInt("Course_Pass"));
                Course2.setCourse_Intro(rs.getString("Course_Intro"));
                Course2.setCourse_Image(rs.getString("Course_Image"));
                Course2.setCourse_Date(rs.getDate("Course_Date"));
                Course2.setCourse_Teacher(rs.getString("Course_Teacher"));
            }
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            DBConnection.closeDB(con, pstmt, rs);
        }
        return Course2;
    }

    public ArrayList<Course> getAllCourse() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        con = DBConnection.getDBConnection();
        String sql = "select * from Course where Course_Pass=1";
        ArrayList<Course> CourseArrayList = new ArrayList<Course>();
        try {
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Course Course3 = new Course();
                Course3.setCourse_Id(rs.getInt("Course_Id"));
                Course3.setCourse_Name(rs.getString("Course_Name"));
                Course3.setCourse_Pass(rs.getInt("Course_Pass"));
                Course3.setCourse_Intro(rs.getString("Course_Intro"));
                Course3.setCourse_Image(rs.getString("Course_Image"));
                Course3.setCourse_Date(rs.getDate("Course_Date"));
                Course3.setCourse_Teacher(rs.getString("Course_Teacher"));
                CourseArrayList.add(Course3);// 把一个商品加入集合
            }
            return CourseArrayList; // 返回集合。
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

    public ArrayList<Course> getSelectedCourse(String str) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        con = DBConnection.getDBConnection();
        String sql = "select * from Course where Course_Name like ? and Course_Pass=1";
        ArrayList<Course> CourseArrayList = new ArrayList<Course>();
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,'%' + str + '%');
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Course Course3 = new Course();
                Course3.setCourse_Id(rs.getInt("Course_Id"));
                Course3.setCourse_Name(rs.getString("Course_Name"));
                Course3.setCourse_Pass(rs.getInt("Course_Pass"));
                Course3.setCourse_Intro(rs.getString("Course_Intro"));
                Course3.setCourse_Image(rs.getString("Course_Image"));
                Course3.setCourse_Date(rs.getDate("Course_Date"));
                Course3.setCourse_Teacher(rs.getString("Course_Teacher"));
                CourseArrayList.add(Course3);// 把一个商品加入集合
            }
            return CourseArrayList; // 返回集合。
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


