package com.company.project.dto.account;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by CodeGenerator on 2019/03/28.
 */
public class AccountDTO {
    @ApiModelProperty(value = "帐号名")
    private String name;

    @ApiModelProperty(value = "昵称")
    private String nickName;

    @ApiModelProperty(value = "头像")
    private String avatar;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}