package com.rebel.ExamPortalSb.Angular.util;

public class Logging
{
    private String userName;
    private String password;

    public Logging() {
    }

    public Logging(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
