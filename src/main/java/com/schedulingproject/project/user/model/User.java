package com.schedulingproject.project.user.model;

import com.schedulingproject.project.user.dto.UserDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String mail;
    private Long dtinsert;
    private Long dtupdate;

    public User() {
    }

    public User of(UserDTO userDTO){
        User user = new User();
        user.setName(userDTO.getName());
        user.setMail(userDTO.getMail());
        return user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getDtinsert() {
        return dtinsert;
    }

    public void setDtinsert(Integer Long) {
        this.dtinsert = dtinsert;
    }

    public Long getDtupdate() {
        return dtupdate;
    }

    public void setDtupdate(Long dtupdate) {
        this.dtupdate = dtupdate;
    }

    @PrePersist
    public void prePersist(){
         this.dtinsert = this.dtupdate = System.currentTimeMillis();
    }

    @PreUpdate
    public void preUpdate(){
        this.dtupdate = System.currentTimeMillis();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(mail, user.mail) && Objects.equals(dtinsert, user.dtinsert) && Objects.equals(dtupdate, user.dtupdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, mail, dtinsert, dtupdate);
    }
}
