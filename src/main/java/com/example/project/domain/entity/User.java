package com.example.project.domain.entity;


import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Builder
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private LocalDateTime deletedAt;
    @Column(nullable = false)
    private String password;
//    @CreatedDate
    private LocalDateTime registeredAt;
//    @ColumnDefault("'USER'")
//    private String role;
    @Enumerated(EnumType.STRING)
//    @Column(name="role")
    private UserRole role = UserRole.USER;

    private LocalDateTime updateAt;
    @Column(nullable = false)
    private String userName;


}

