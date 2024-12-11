package com.altercode.gerencg.controller;

import com.altercode.gerencg.dto.TagDTO;
import com.altercode.gerencg.service.interf.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping("/list")
    public ResponseEntity<Page<TagDTO>> findAllTags(@RequestParam(defaultValue = "") String tagId, Pageable pageable) {
        Page<TagDTO> list = tagService.findAllTags(tagId, pageable);
        return ResponseEntity.ok(list);
    }

    @PostMapping("/add")
    public ResponseEntity<TagDTO> saveTag(@RequestBody TagDTO dto){
        TagDTO add = tagService.saveTag(dto);
        return  new ResponseEntity<>(add, HttpStatus.CREATED);
    }

    @PostMapping("/all-tags-by-title")
    @ResponseBody
    public List<TagDTO> findAllByTitle(@RequestBody List<TagDTO> dto) {
        List<String> titles = new ArrayList<>();
        for (TagDTO title : dto) {
            titles.add(title.getTagId());
        }
        return tagService.getAllTags(titles);
    }
}
