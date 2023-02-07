package com.example.prototipo.models;

public class User {
    private String codigo;
    private String userType;
    private String username;
    private String password;

    public User() {
    }

    public User(String codigo, String userType, String username, String password) {
        this.codigo = codigo;
        this.userType = userType;
        this.username = username;
        this.password = password;
    }

    public User(String userType, String username){
        this.username = username;
        this.userType = userType;
        this.password = null;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
