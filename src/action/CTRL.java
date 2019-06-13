package action;
import com.opensymphony.xwork2.ActionSupport;
import db.DBConnection;
import org.apache.struts2.interceptor.SessionAware;
import dao.UserDao;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CTRL {
    private User user;
    private UserDao userDao = new UserDao();
    private List<User> list;
    private List<User> list1=new ArrayList<User>();
    public void setList(List<User> list) {
        this.list = list;
    }
    public List<User> getList() {
        return list;
    }

    public String userdisplay() throws Exception {
        //用户登录Action方法
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        con = DBConnection.getDBConnection();
        User user2 = null;
        String sql = "select * from user";
        System.out.println("///");
        String forward = null;
        try {
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                user2 = new User();
                user2.setUser_id(rs.getInt("User_id"));
                user2.setUser_Name(rs.getString("User_Name"));
                user2.setUser_Password(rs.getString("User_Password"));
                user2.setUser_Identity(rs.getInt("User_Identity"));
                user2.setUser_Intro(rs.getString("User_Intro"));
                list1.add(user2);
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
        this.setList(list1);
        return forward;
    }
    private int u_id=0;

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String userdelete(){
        userDao.delete1(u_id);
        userDao.delete2(u_id);
        userDao.delete3(u_id);
        userDao.delete(u_id);
        return "success";
    }
}
