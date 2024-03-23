package com.share.share_scripts.dto.follow;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GetToUserFollowRequest {
    @NotNull(message = "to user의 id 값을 넣어주세요.")
    private Long toUser;
}
