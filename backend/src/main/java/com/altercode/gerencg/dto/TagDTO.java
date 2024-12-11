package com.altercode.gerencg.dto;

import com.altercode.gerencg.entity.Tag;
import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;

@Getter
public class TagDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

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
}
