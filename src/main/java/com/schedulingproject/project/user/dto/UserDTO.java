package com.schedulingproject.project.user.dto;

import com.schedulingproject.project.user.model.User;

public class UserDTO {

    private String name;
    private String mail;


    public UserDTO of(User user){
        UserDTO userdto = new UserDTO();
        userdto.setName(user.getName());
        userdto.setMail(user.getMail());
        return userdto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

}
