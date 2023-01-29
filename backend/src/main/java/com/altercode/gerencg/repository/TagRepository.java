package com.altercode.gerencg.repository;


import com.altercode.gerencg.entity.OrderCode;
import com.altercode.gerencg.entity.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends JpaRepository<Tag, String> {

    @Query("SELECT obj FROM Tag obj WHERE obj.tagId LIKE %?1%")
    Page<Tag> findAllTags(Pageable pageable, String tagId);

/*
    List<Tag> findAllByTitle(List<String> title);
*/
}
