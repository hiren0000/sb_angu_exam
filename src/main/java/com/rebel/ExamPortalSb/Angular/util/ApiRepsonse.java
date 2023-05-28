package com.rebel.ExamPortalSb.Angular.util;

public class ApiRepsonse
{
    private String message;


    public ApiRepsonse() {
    }

    public ApiRepsonse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
