package com.pantigoso.app.springbases.models.dto;

import com.pantigoso.app.springbases.models.User;

public class UserDto {

    //un DTO es un pojo un clase simple con getters and setters
    public String title;
    public User user;
    
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    

}
