package com.altercode.gerencg.repository;


import com.altercode.gerencg.entity.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, String> {


    @Query("SELECT obj FROM Tag obj WHERE UPPER(obj.tagId) " +
            "LIKE UPPER(concat('%', ?1, '%')) " +
            "ORDER BY (obj.tagId) DESC")
    Page<Tag> findAllTags(String tagId, Pageable pageable);

}