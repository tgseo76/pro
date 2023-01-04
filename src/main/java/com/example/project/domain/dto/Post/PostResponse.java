package com.example.project.domain.dto.Post;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

public class PostResponse {

    private String message;
    private Long postId;

    public PostResponse(String message, Long postId) {
        this.message = message;
        this.postId = postId;
    }

    public PostResponse() {
    }
}
