package dto.user;

import domain.user.User;
import lombok.Getter;

import java.sql.Blob;
import java.util.Date;

@Getter
public class UserResponse {
    private final Long userNo;
    private final String userName;
    private final String userId;
    private final String userPw;
    private final String userEmail;
    private final String userPhone;
    private final Date userBirth;
    private final Integer userGender;
    private final Blob userImg;

    public UserResponse(User user) {
        this.userNo = user.getUserNo();
        this.userName = user.getUsername();
        this.userId = user.getUserId();
        this.userPw = user.getUserPw();
        this.userEmail = user.getUserEmail();
        this.userPhone = user.getUserPhone();
        this.userBirth = user.getUserBirth();
        this.userGender = user.getUserGender();
        this.userImg = user.getUserImg();
    }
}
