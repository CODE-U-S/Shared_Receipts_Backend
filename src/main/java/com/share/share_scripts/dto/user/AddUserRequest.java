package com.share.share_scripts.dto.user;

import com.share.share_scripts.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddUserRequest {
    private String userName;
    private String userId;
    private String userPw;
    private String userEmail;
    private String userPhone;
    private Date userBirth;
    private Integer userGender;
    private String userImg;

    public User toEntity() {
        return User.builder()
                .userName(userName)
                .userId(userId)
                .userPw(userPw)
                .userEmail(userEmail)
                .userPhone(userPhone)
                .userBirth(userBirth)
                .userGender(userGender)
                .userImg(userImg)
                .build();
    }
}
