package model;

public class user_has_chapter {
    private String User_User_Name;
    private int Chapter_Chapter_id;

    public user_has_chapter(){

    }

    public user_has_chapter(String User_User_Name, int Chapter_Chapter_id){
        this.User_User_Name = User_User_Name;
        this.Chapter_Chapter_id = Chapter_Chapter_id;
    }

    public String getUser_User_Name() {
        return User_User_Name;
    }

    public void setUser_User_Name(String user_User_Name) {
        User_User_Name = user_User_Name;
    }

    public int getChapter_Chapter_id() {
        return Chapter_Chapter_id;
    }

    public void setChapter_Chapter_id(int chapter_Chapter_id) {
        Chapter_Chapter_id = chapter_Chapter_id;
    }
}
