package com.altercode.gerencg.dto;

import com.altercode.gerencg.entity.Tag;

import java.io.Serializable;

public class TagDTO implements Serializable {

    private String tagId;
    private String description;

    public TagDTO() {
    }

    public TagDTO(String tagId) {
        this.tagId = tagId;
    }


    public TagDTO(Tag entity) {
       tagId = entity.getTagId();
       description = entity.getDescription();
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
