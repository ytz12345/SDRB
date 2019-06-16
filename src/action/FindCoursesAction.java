package action;
import conn.DBConnection;
import model.Course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FindCoursesAction {
    private List<Course> courseList;
    private List<Course> courseList1 =new ArrayList<Course>();
    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }
    public List<Course> getCourseList() {
        return courseList;
    }


    public String FindC() throws Exception{
        //从数据库查找指定用户的课程并返回课程ID数组
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Course temp_course = null;
        String forward = null;
        con = DBConnection.getDBConnection();
        String sql = "SELECT course.* FROM user_has_course,course WHERE User_User_id =? and user_has_course.Course_Course_Id=course.Course_Id";
        try{
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, u2_id);
            System.out.println("printing user id ... ");
            System.out.println(u2_id);
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

    public int u2_id = 0;

    public int getU2_id() {
        return u2_id;
    }

    public void setU2_id(int u2_id) {
        this.u2_id = u2_id;
    }
}