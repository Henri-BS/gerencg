package com.altercode.gerencg.repository;


import com.altercode.gerencg.entity.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, String> {

    @Query("SELECT obj FROM Tag obj WHERE obj.title LIKE %?1%")
    Page<Tag> findTagsByTitle(Pageable pageable, String title);
}
