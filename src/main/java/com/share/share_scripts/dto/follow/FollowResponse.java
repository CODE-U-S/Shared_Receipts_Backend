package com.share.share_scripts.dto.follow;

import com.share.share_scripts.domain.follow.Follow;
import com.share.share_scripts.domain.user.User;
import lombok.Getter;

@Getter
public class FollowResponse {
    private final Long toUser;
    private final User fromUser;

    public FollowResponse(Follow follow) {
        this.toUser = follow.getToUser();
        this.fromUser = follow.getFromUser();
    }
}

