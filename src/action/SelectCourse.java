package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.UserDao;
import model.User;

public class SelectCourse extends ActionSupport{
        private String str;
        public String execute() throws Exception {
            //传递搜索参数
            return SUCCESS;
        }

        public void setStr(String str) {this.str = str;}
        public String getStr() {return str;}
    }
