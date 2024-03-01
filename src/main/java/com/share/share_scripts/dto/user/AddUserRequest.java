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
    private String name;

    @NotBlank
    private String userId;

    @NotBlank
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}")
    private String pw;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Pattern(regexp = "(0\\d{1,2})-(\\d{3,4})-(\\d{4})")
    private String phone;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent
    private LocalDate birth;

    @NotNull
    private Integer gender;

    private String img;

    public User toEntity() {
        return User.builder()
                .name(name)
                .userId(userId)
                .pw(pw)
                .email(email)
                .phone(phone)
                .birth(birth)
                .gender(gender)
                .img(img)
                .build();
    }
}
