package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.UserDao;
import model.User;

public class SelectCourse extends ActionSupport{
        private String str;
        public String execute() throws Exception {
            //传递搜索参数
            String forward = "success";
            return forward;
        }

        public String getStr() {return str;}
    }
