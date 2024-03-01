package com.share.share_scripts.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.share.share_scripts.domain.favorite.Favorite;
import com.share.share_scripts.domain.post.Post;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "pw")
    private String pw;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "birth")
    private LocalDate birth;

    @Column(name = "gender")
    private Integer gender;

    @Column(name = "img")
    private String img;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true)
    private List<Post> postList;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true)
    private List<Favorite> favoriteList;

    @Builder
    public User(String name, String userId, String pw, String email, String phone, LocalDate birth, Integer gender, String img) {
        this.name = name;
        this.userId = userId;
        this.pw = pw;
        this.email = email;
        this.phone = phone;
        this.birth = birth;
        this.gender = gender;
        this.img = img;
    }

    public void update(String name, String pw, Integer gender, String img) {
        this.name = name;
        this.pw = pw;
        this.gender = gender;
        this.img = img;
    }
}
