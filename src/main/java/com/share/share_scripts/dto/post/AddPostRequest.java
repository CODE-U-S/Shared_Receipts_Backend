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
    private User userNo;
    private Long userCount;
    private String postTitle;
    private String postTag;
    private String postExplain;

    public Post toEntity() {
        return Post.builder()
                .userNo(userNo)
                .userCount(userCount)
                .postTitle(postTitle)
                .postTag(postTag)
                .postExplain(postExplain)
                .build();
    }
}
