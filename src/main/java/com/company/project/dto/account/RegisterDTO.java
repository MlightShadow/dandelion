package com.company.project.dto.account;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by CodeGenerator on 2019/03/28.
 */
public class RegisterDTO {
    @ApiModelProperty(value = "帐号名")
    private String name;

    @ApiModelProperty(value = "密码")
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}