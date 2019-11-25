package com.company.project.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by CodeGenerator on 2019/06/26.
 */
public class NotesDTO {
    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "内容")
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}