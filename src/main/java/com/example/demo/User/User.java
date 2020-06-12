package com.example.demo.User;

public class User {
    private String username;
    private String fullname;
    private String password;
    private int isAdmin;


    public User(){

    }

    public User(String username,String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String fullname, String password, int isAdmin) {
        this.username = username;
        this.fullname = fullname;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }
}
