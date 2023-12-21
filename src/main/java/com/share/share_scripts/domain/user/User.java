package com.share.share_scripts.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.share.share_scripts.domain.favorite.Favorite;
import com.share.share_scripts.domain.post.Post;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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

    @NotBlank(message = "사용자 이름은 필수값 입니다.")
    @Column(name = "user_name")
    private String userName;

    @NotBlank(message = "사용자 아이디는 필수값 입니다.")
    @Column(name = "user_id")
    private String userId;

    @NotBlank(message = "사용자 비밀번호는 필수값 입니다.")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}",
             message = "비밀번호는 영문 대,소문자와 숫자, 특수기호가 적어도 1개 이상씩 포함된 8자 ~ 16자의 비밀번호여야 합니다.")
    @Column(name = "user_pw")
    private String userPw;

    @NotBlank(message = "사용자 이메일은 필수값 입니다.")
    @Email(message = "이메일 형식이 아닙니다.")
    @Column(name = "user_email")
    private String userEmail;

    @NotBlank(message = "사용자 전화번호는 필수값 입니다.")
    @Pattern(regexp = "(0\\d{1,2})-(\\d{3,4})-(\\d{4})",
             message = "전화번호 형식이 아닙니다.")
    @Column(name = "user_phone")
    private String userPhone;

    @NotBlank(message = "사용자 생년월일은 필수값 입니다.")
    @Pattern(regexp = "\\d{4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])",
             message = "생년월일 형식이 아닙니다.")
    @PastOrPresent(message = "미래값은 들어갈 수 없습니다.")
    @Column(name = "user_birth")
    private Date userBirth;

    @NotNull(message = "사용자 성별은 필수값 입니다.")
    @Column(name = "user_gender")
    private Integer userGender;

    @Column(name = "user_img")
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
