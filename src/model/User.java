package model;

public class User {

    public String user_Name;
    public String user_Password;
    public int user_Identity;
    public User(){

    }

    public User(String user_Name, String user_Password,int user_Identity){
        this.user_Name = user_Name;
        this.user_Password = user_Password;
        this.user_Identity=user_Identity;
    }

    public String getUsername(){
        return user_Name;
    }

    public void setUsername(String user_Name){
        this.user_Name = user_Name;
    }

    public String getPassword(){
        return user_Password;
    }

    public void setPassword(String user_Password){
        this.user_Password = user_Password;
    }

    public int getUser_Identity() {
        return user_Identity;
    }

    public void setUser_Identity(int user_Identity) {
        this.user_Identity = user_Identity;
    }
}
