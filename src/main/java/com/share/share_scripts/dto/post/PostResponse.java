package com.share.share_scripts.dto.post;

import com.share.share_scripts.domain.post.Post;
import com.share.share_scripts.domain.user.User;
import lombok.Getter;

@Getter
public class PostResponse {
    private Long postNo;
    private User userNo;
    private Long userCount;
    private String postTitle;
    private String postTag;
    private String postExplain;

    public PostResponse(Post post) {
        this.postNo = post.getPostNo();
        this.userNo = post.getUserNo();
        this.userCount = post.getUserCount();
        this.postTitle = post.getPostTitle();
        this.postTag = post.getPostTag();
        this.postExplain = post.getPostExplain();
    }
}
