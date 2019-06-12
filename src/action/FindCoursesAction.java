package action;
import dao.UserDao;
import dao.user_has_courseDao;
import model.User;

public class FindCoursesAction {
    private User user;
    private UserDao userDao = new UserDao();
    private user_has_courseDao user_has_courseDao=new user_has_courseDao();
    private int[] list;
    private int[] list1 = new int[100];

    public void setList(int[] list) {
        this.list = list;
    }

    public int[] getList() {
        return list;
    }


    public int u2_id = 0;

    public int getU2_id() {
        return u2_id;
    }

    public void setU2_id(int u2_id) {
        this.u2_id = u2_id;
    }

    public String FindC(){
        //从数据库查找指定用户的课程并返回课程ID数组
        user_has_courseDao.FindCourseIds(u2_id);
        return "success";
    }
}