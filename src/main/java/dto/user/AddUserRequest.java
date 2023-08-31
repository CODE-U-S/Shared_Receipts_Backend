package dto.user;

import domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Blob;
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
    private Blob userImg;

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
