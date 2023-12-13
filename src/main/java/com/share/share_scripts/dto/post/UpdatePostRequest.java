package com.share.share_scripts.dto.post;

import com.share.share_scripts.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UpdatePostRequest {
    private Long userCount;
    private String postTitle;
    private String postTag;
    private String postExplain;
}
