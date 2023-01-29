package com.altercode.gerencg.controller;

import com.altercode.gerencg.dto.TagDTO;
import com.altercode.gerencg.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping("/tag-list/{tagId}")
    public ResponseEntity<Page<TagDTO>> findTagsByTitle(Pageable pageable, @PathVariable String tagId) {
        Page<TagDTO> list = tagService.findAllTags(pageable, tagId);
        return ResponseEntity.ok(list);
    }

    @PostMapping("/all-tags-by-title")
    @ResponseBody
    public List<TagDTO> findAllByTitle(@RequestBody List<TagDTO> dto) {
        List<String> titles = new ArrayList<>();
        for (TagDTO title : dto) {
            titles.add(title.getTagId());
        }
        return (List<TagDTO>) tagService.getAllTags(titles);
    }

/*    @GetMapping("/get-by-tags/{tagId}")
    public ResponseEntity<List<OrderCodeDTO>> findAllOrdersByTags(@PathVariable String tagId) {
        List<OrderCodeDTO> list = tagService.findAllOrdersByTag(tagId);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }*/
}
