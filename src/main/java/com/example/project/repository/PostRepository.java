package com.example.project.repository;

import com.example.project.domain.entity.Post;
import com.example.project.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post,Long> {
    Optional<Post> findById(Long id);

}
