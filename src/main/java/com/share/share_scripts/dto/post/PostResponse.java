package com.share.share_scripts.dto.post;

import com.share.share_scripts.domain.post.Post;
import com.share.share_scripts.domain.user.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostResponse {
    private Long id;
    private User user;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private Long count;
    private String title;
    private String tag;
    private String explain;

    public PostResponse(Post post) {
        this.id = post.getId();
        this.user = post.getUser();
        this.createdDate = post.getCreatedDate();
        this.modifiedDate = post.getModifiedDate();
        this.count = post.getUserCount();
        this.title = post.getTitle();
        this.tag = post.getTag();
        this.explain = post.getExplain();
    }
}
