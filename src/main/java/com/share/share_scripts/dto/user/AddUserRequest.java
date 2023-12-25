package com.share.share_scripts.dto.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.share.share_scripts.domain.user.User;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddUserRequest {
    @NotBlank
    private String userName;

    @NotBlank
    private String userId;

    @NotBlank
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}")
    private String userPw;

    @NotBlank
    @Email
    private String userEmail;

    @NotBlank
    @Pattern(regexp = "(0\\d{1,2})-(\\d{3,4})-(\\d{4})")
    private String userPhone;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent
    private LocalDate userBirth;

    @NotNull
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
