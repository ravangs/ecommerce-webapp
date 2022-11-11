package com.ooad.ecommerce.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user", schema = "ecommerce", indexes = {
        @Index(name = "user_user_name_uindex", columnList = "user_name", unique = true)
})
public class User {
    @Id
    @Column(name = "user_id", nullable = false)
    private Integer id;

    @Size(max = 63)
    @NotNull
    @Column(name = "user_name", nullable = false, length = 63)
    private String userName;

    @Size(max = 127)
    @NotNull
    @Column(name = "password", nullable = false, length = 127)
    private String password;

    @NotNull
    @Lob
    @Column(name = "user_type", nullable = false)
    private String userType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

}