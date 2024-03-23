package com.share.share_scripts.dto.follow;

import com.share.share_scripts.domain.user.User;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GetFromUserFollowRequest {
    @NotNull(message = "from user의 id 값을 넣어주세요.")
    private User fromUser;
}
