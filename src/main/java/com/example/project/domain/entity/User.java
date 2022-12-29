package com.example.project.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private LocalDateTime deletedAt;
    @Column(nullable = false)
    private String password;
    private LocalDateTime registeredAt;
    private UserRole role;
    private LocalDateTime updateAt;
    @Column(nullable = false)
    private String userName;


}

