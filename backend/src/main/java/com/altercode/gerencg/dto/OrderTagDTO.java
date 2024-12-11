package com.altercode.gerencg.dto;

import com.altercode.gerencg.entity.OrderTag;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class OrderTagDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String codeId;
    private String tagId;
    private LocalDate orderDate;
    private String distributor;
    private String category;

    public OrderTagDTO(OrderTag entity) {
        id = entity.getId();
        codeId = entity.getOrder().getCode();
        tagId = entity.getTag().getTagId();
        
    }
}
