package com.company.project.dto;

public class LoginDTO {

    /**
     * 帐号名
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}