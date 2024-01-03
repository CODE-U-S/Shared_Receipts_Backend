package com.share.share_scripts.dto.post;

import com.share.share_scripts.domain.post.Post;
import com.share.share_scripts.domain.user.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostResponse {
    private Long postNo;
    private User user;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private Long userCount;
    private String postTitle;
    private String postTag;
    private String postExplain;

    public PostResponse(Post post) {
        this.postNo = post.getPostNo();
        this.user = post.getUser();
        this.createdDate = post.getCreatedDate();
        this.modifiedDate = post.getModifiedDate();
        this.userCount = post.getUserCount();
        this.postTitle = post.getPostTitle();
        this.postTag = post.getPostTag();
        this.postExplain = post.getPostExplain();
    }
}
