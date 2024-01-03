package com.share.share_scripts.dto.post;

import com.share.share_scripts.domain.post.Post;
import com.share.share_scripts.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddPostRequest {
    private User user;
    private Long userCount;
    private String postTitle;
    private String postTag;
    private String postExplain;

    public Post toEntity() {
        return Post.builder()
                .user(user)
                .userCount(userCount)
                .postTitle(postTitle)
                .postTag(postTag)
                .postExplain(postExplain)
                .build();
    }
}
