package com.altercode.gerencg.repository;


import com.altercode.gerencg.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, String> {
}
