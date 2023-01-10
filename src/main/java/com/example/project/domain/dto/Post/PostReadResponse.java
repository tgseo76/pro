package com.example.project.domain.dto.Post;

import com.example.project.domain.entity.Post;
import lombok.*;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostReadResponse {
    private Long id;
    private String title;
    private String body;
    private String userName;
    private String createdAt;
    private String lastModifiedAt;

    /* Page<Entity> -> Page<Dto> 변환처리 */
    public static Page<PostReadResponse> toDtoList(Page<Post> postEntities){
        Page<PostReadResponse> postDtoList = postEntities.map(m -> PostReadResponse.builder()
                .id(m.getId())
                .title(m.getTitle())
                .body(m.getBody())
                .userName(m.getUser().getUserName())
                .createdAt(m.getCreatedAt())
                .build());
        return postDtoList;
    }

}
