package model;

public class User {

    public String user_Name;
    public String user_Password;

    public User(){

    }

    public User(String user_Name, String user_Password){
        this.user_Name = user_Name;
        this.user_Password = user_Password;
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
}
