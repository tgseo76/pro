package com.example.project.domain.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.parameters.P;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_count")
    public Long id;
    private String title;
    private String body;
    @ManyToOne
    private User user;

    @CreatedDate
    @Column(name = "createdAt",updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime LastModifiedAt;







//    public static Post of(String title, String body, User user) {
//        Post entity = new Post();
//        entity.setTitle(title);
//        entity.setBody(body);
//        entity.setUser(user);
//        return entity;
//    }


}
