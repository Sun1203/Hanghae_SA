package com.sparta.submit.repository;

import com.sparta.submit.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByOrderByCreatedAtDesc();
}
