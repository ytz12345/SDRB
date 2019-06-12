package model;

import java.sql.Timestamp;

public class Comment {
    private int Comment_id;
    private String Comment_Content;
    private Timestamp Comment_Time;
    private int Comment_To;
    private int Chapter_Chapter_id;
    private int User_User_id;

    public Comment(){

    }

    public Comment(int Comment_id, String Comment_Content, Timestamp Comment_Time, int Comment_To, int Chapter_Chapter_id, int User_User_id){
        this.Comment_id = Comment_id;
        this.Comment_Content = Comment_Content;
        this.Comment_Time = Comment_Time;
        this.Comment_To = Comment_To;
        this.Chapter_Chapter_id = Chapter_Chapter_id;
        this.User_User_id = User_User_id;
    }

    public int getComment_id() {
        return Comment_id;
    }

    public void setComment_id(int comment_id) {
        Comment_id = comment_id;
    }

    public String getComment_Content() {
        return Comment_Content;
    }

    public void setComment_Content(String comment_Content) {
        Comment_Content = comment_Content;
    }

    public Timestamp getComment_Time() {
        return Comment_Time;
    }

    public void setComment_Time(Timestamp comment_Time) {
        Comment_Time = comment_Time;
    }

    public int getComment_To() {
        return Comment_To;
    }

    public void setComment_To(int comment_To) {
        Comment_To = comment_To;
    }

    public int getChapter_Chapter_id() {
        return Chapter_Chapter_id;
    }

    public void setChapter_Chapter_id(int chapter_Chapter_id) {
        Chapter_Chapter_id = chapter_Chapter_id;
    }

    public int getUser_User_id() {
        return User_User_id;
    }

    public void setUser_User_id(int user_User_id) {
        User_User_id = user_User_id;
    }
}
