package com.altercode.gerencg.controller;

import com.altercode.gerencg.dto.TagDTO;
import com.altercode.gerencg.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TagController {
    @Autowired
    private TagService tagService;

    @GetMapping("/tag-list/{title}")
    public ResponseEntity<Page<TagDTO>> findTagsByTitle(Pageable pageable, @PathVariable String title) {
        Page<TagDTO> list = tagService.findTagsByTitle(pageable, title);
        return ResponseEntity.ok(list);
    }
}
