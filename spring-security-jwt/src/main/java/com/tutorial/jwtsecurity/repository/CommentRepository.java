package com.tutorial.jwtsecurity.repository;

import com.tutorial.jwtsecurity.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
