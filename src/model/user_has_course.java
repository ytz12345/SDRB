package model;

public class user_has_course {
    private String User_User_Name;
    private int Course_Course_Id;

    public user_has_course(){

    }

    public user_has_course(String User_User_Name, int Course_Course_Id){
        this.User_User_Name = User_User_Name;
        this.Course_Course_Id = Course_Course_Id;
    }

    public String getUser_User_Name() {
        return User_User_Name;
    }

    public void setUser_User_Name(String user_User_Name) {
        User_User_Name = user_User_Name;
    }

    public int getCourse_Course_Id() {
        return Course_Course_Id;
    }

    public void setCourse_Course_Id(int course_Course_Id) {
        Course_Course_Id = course_Course_Id;
    }
}
