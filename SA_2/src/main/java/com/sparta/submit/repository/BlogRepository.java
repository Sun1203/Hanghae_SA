package com.sparta.submit.repository;

import com.sparta.submit.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Long> {
    List<Blog> findByOrderByCreatedAtDesc();
}
