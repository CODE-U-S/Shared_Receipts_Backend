package com.share.share_scripts.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UpdateUserRequest {
    private String userName;
    private String userPw;
    private Integer userGender;
    private String userImg;
}
