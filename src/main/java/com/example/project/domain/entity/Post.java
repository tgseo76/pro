package com.example.project.domain.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.parameters.P;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
    private String createdAt;

    @LastModifiedDate
    private String lastModifiedAt;

    @PrePersist
//      String으로 바꾸기
    public void onPrePersist(){
        this.createdAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        this.lastModifiedAt = this.createdAt;
    }

    @PreUpdate
    public void onPreUpdatePersist(){
        this.lastModifiedAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }






//    public static Post of(String title, String body, User user) {
//        Post entity = new Post();
//        entity.setTitle(title);
//        entity.setBody(body);
//        entity.setUser(user);
//        return entity;
//    }


}
