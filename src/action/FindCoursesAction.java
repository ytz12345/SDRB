package action;
import com.opensymphony.xwork2.ActionSupport;
import db.DBConnection;
import org.apache.struts2.interceptor.SessionAware;
import dao.UserDao;
import dao.user_has_courseDao;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FindCoursesAction {
    private User user;
    private UserDao userDao = new UserDao();
    private int[] list;
    private int[] list1 = new int[100];

    public void setList(int[] list) {
        this.list = list;
    }

    public int[] getList() {
        return list;
    }


    private int user_id = 0;

    public int getUser_id_id() {
        return user_id;
    }

    public void setUser_id_id(int u_id) {
        this.user_id = user_id;
    }

    public String FindC() throws Exception {
        //从数据库查找指定用户的课程并返回课程ID数组
        user_has_courseDao.FindCourseIds(user_id);
        return "success";
    }
}