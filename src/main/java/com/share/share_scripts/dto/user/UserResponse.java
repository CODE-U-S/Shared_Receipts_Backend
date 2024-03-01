package com.share.share_scripts.dto.user;

import com.share.share_scripts.domain.user.User;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Date;

@Getter
public class UserResponse {
    private final Long id;
    private final String name;
    private final String userId;
    private final String pw;
    private final String email;
    private final String phone;
    private final LocalDate birth;
    private final Integer gender;
    private final String img;

    public UserResponse(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.userId = user.getUserId();
        this.pw = user.getPw();
        this.email = user.getEmail();
        this.phone = user.getPhone();
        this.birth = user.getBirth();
        this.gender = user.getGender();
        this.img = user.getImg();
    }
}
