package com.share.share_scripts.dto.user;

import com.share.share_scripts.domain.user.User;
import jakarta.validation.constraints.*;
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
    @NotBlank(message = "사용자 이름은 필수값 입니다.")
    private String userName;

    @NotBlank(message = "사용자 아이디는 필수값 입니다.")
    private String userId;

    @NotBlank(message = "사용자 비밀번호는 필수값 입니다.")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}",
            message = "비밀번호는 영문 대,소문자와 숫자, 특수기호가 적어도 1개 이상씩 포함된 8자 ~ 16자의 비밀번호여야 합니다.")
    private String userPw;

    @NotBlank(message = "사용자 이메일은 필수값 입니다.")
    @Email(message = "이메일 형식이 아닙니다.")
    private String userEmail;

    @NotBlank(message = "사용자 전화번호는 필수값 입니다.")
    @Pattern(regexp = "(0\\d{1,2})-(\\d{3,4})-(\\d{4})",
            message = "전화번호 형식이 아닙니다.")
    private String userPhone;

    @NotBlank(message = "사용자 생년월일은 필수값 입니다.")
    @Pattern(regexp = "\\d{4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])",
            message = "생년월일 형식이 아닙니다.")
    @PastOrPresent(message = "미래값은 들어갈 수 없습니다.")
    private Date userBirth;

    @NotNull(message = "사용자 성별은 필수값 입니다.")
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
