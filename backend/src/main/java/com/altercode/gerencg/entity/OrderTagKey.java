package com.altercode.gerencg.entity;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class OrderTagKey implements Serializable {

    @Column(name = "code_id")
    private String codeId;

    @Column(name = "tag_id")
    private String tagId;
}
