package com.altercode.gerencg.dto;

import com.altercode.gerencg.entity.Tag;

import java.io.Serializable;

public class TagDTO implements Serializable {

    private String title;
    private String description;

    public TagDTO() {
    }

    public TagDTO(String title) {
        this.title = title;
    }


    public TagDTO(Tag entity) {
       title = entity.getTitle();
       description = entity.getDescription();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
