package action;

import model.Comment;
import dao.CommentDao;

public class LeaveCommentAction {
    private Comment comment;
    private int login_id;
    private CommentDao commentDao = new CommentDao();

    public String LeaveComment()throws Exception{
        //System.out.println("尝试留言");
        String forward = "failure";//数据库存数据时出错标记值
        if(comment.getUser_User_id()==0) forward = "no_login";
        int flag = 0;
        flag = commentDao.save(comment);
        if(flag == 1) {
            forward = "success";//成功注册标记值
        }
        return forward;
    }

    public Comment getComment(){
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public int getLogin_id() {
        return login_id;
    }

    public void setLogin_id(int login_id) {
        this.login_id = login_id;
    }
}
