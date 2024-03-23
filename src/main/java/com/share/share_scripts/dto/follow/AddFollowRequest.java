package com.share.share_scripts.dto.follow;

import com.share.share_scripts.domain.follow.Follow;
import com.share.share_scripts.domain.user.User;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddFollowRequest {
    @NotNull(message = "to user의 id 값을 넣어주세요.")
    private Long toUser;

    public Follow toEntity(Long toUser, User fromUser) {
        return new Follow(toUser, fromUser);
    }
}
