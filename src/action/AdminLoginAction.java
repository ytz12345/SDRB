package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.UserDao;
import model.User;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class AdminLoginAction extends ActionSupport{
        private User user;
        private UserDao userDao = new UserDao();
        public String execute() throws Exception {
        //用户登录Action方法
        String forward = null;
        User user2 = userDao.find(user);
        if(user2 != null) {
            if(user2.getUser_Identity()==0)
                forward = "success";
            else
                forward = "failure";
        }else {
            forward = "failure";
        }
        return forward;
    }

        public User getUser() {
        return user;
    }

        public void setUser(User user) {
        this.user = user;
    }

    }
