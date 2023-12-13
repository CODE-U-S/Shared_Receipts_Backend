package com.share.share_scripts.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.share.share_scripts.domain.favorite.Favorite;
import com.share.share_scripts.domain.post.Post;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_no", updatable = false)
    private Long userNo;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "user_pw", nullable = false)
    private String userPw;

    @Column(name = "user_email", nullable = false)
    private String userEmail;

    @Column(name = "user_phone", nullable = false)
    private String userPhone;

    @Column(name = "user_birth", nullable = false)
    private Date userBirth;

    @Column(name = "user_gender", nullable = false)
    private Integer userGender;

    @Column(name = "user_img", nullable = false)
    private String userImg;

    @JsonIgnore
    @OneToMany(mappedBy = "userNo", cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true)
    private List<Post> postList;

    @JsonIgnore
    @OneToMany(mappedBy = "userNo", cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true)
    private List<Favorite> favoriteList;

    @Builder
    public User(String userName, String userId, String userPw, String userEmail, String userPhone, Date userBirth, Integer userGender, String userImg) {
        this.userName = userName;
        this.userId = userId;
        this.userPw = userPw;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.userBirth = userBirth;
        this.userGender = userGender;
        this.userImg = userImg;
    }

    public void update(String userName, String userId, String userPw, String userEmail, String userPhone, Date userBirth, Integer userGender, String userImg) {
        this.userName = userName;
        this.userId = userId;
        this.userPw = userPw;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.userBirth = userBirth;
        this.userGender = userGender;
        this.userImg = userImg;
    }
}
