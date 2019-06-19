package action;

import model.Comment;
import dao.CommentDao;

public class DeleteCommentAction {
    private int comment_id;
    private int comment_chapter_id;
    private int login_id;
    private CommentDao commentDao = new CommentDao();

    public String DeleteComment()throws Exception{
        ///System.out.println("删除留言");
        int flag = 0;
        commentDao.delete(comment_id);
        String forward = "success";//成功注册标记值
        return forward;
    }

    public int getComment_id(){
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public int getComment_chapter_id(){
        return comment_chapter_id;
    }

    public void setComment_chapter_id(int comment_chapter_id) {
        this.comment_chapter_id = comment_chapter_id;
    }

    public int getLogin_id() {
        return login_id;
    }

    public void setLogin_id(int login_id) {
        this.login_id = login_id;
    }
}
