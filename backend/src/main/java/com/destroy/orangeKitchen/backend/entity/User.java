package com.destroy.orangeKitchen.backend.entity;
import org.apache.commons.codec.digest.DigestUtils;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private String email;
    private String kitchen;
    private String originals;
    private String passwordHash;

    public User(){
    }

    public User(Long id, String userName, String email, String kitchen, String originals, String passwordHash) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.kitchen = kitchen;
        this.originals = originals;
        this.passwordHash = DigestUtils.sha1Hex(passwordHash);
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKitchen() {
        return kitchen;
    }

    public void setKitchen(String kitchen) {
        this.kitchen = kitchen;
    }

    public String getOriginals() {
        return originals;
    }

    public void setOriginals(String originals) {
        this.originals = originals;
    }

    public void setPasswordHash(String passWord){
        this.passwordHash = DigestUtils.sha1Hex(passWord);
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public Long getId() {
        return id;
    }
}
