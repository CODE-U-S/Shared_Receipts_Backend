package dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Blob;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UpdateUserRequest {
    private String userName;
    private String userId;
    private String userPw;
    private String userEmail;
    private String userPhone;
    private Date userBirth;
    private Integer userGender;
    private Blob userImg;
}
