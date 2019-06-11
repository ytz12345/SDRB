package action;

import model.Comment;
import dao.CommentDao;

public class LeaveCommentAction {
    private Comment comment;
    private CommentDao commentDao = new CommentDao();

    public String LeaveComment()throws Exception{
        System.out.println("尝试留言");
        System.out.println(comment.getUser_User_id());
        System.out.println(comment.getComment_Content());
        System.out.println(comment.getChapter_Chapter_id());
        System.out.println(comment.getComment_To());
        System.out.println(comment.getComment_Time());
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
}
