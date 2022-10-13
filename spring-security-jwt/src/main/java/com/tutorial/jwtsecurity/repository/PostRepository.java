package com.tutorial.jwtsecurity.repository;

import com.tutorial.jwtsecurity.entity.Member;
import com.tutorial.jwtsecurity.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {

    Optional<Post> findByMember(Member member);
}
