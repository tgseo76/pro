package com.example.project.domain.dto.Post;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder

public class PostRequest {

    private String title;
    private String body;

    public PostRequest(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public PostRequest() {
    }
}
