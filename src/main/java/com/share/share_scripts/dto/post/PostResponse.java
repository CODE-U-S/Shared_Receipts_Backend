package com.share.share_scripts.dto.post;

import com.share.share_scripts.domain.post.Post;
import com.share.share_scripts.domain.user.User;
import lombok.Getter;

@Getter
public class PostResponse {
    private Long postNo;
    private User userNo;
    private Long receiptCount;
    private String title;
    private String tag;
    private String explain;

    public PostResponse(Post post) {
        this.postNo = post.getPostNo();
        this.userNo = post.getUserNo();
        this.receiptCount = post.getReceiptCount();
        this.title = post.getTitle();
        this.tag = post.getTag();
        this.explain = post.getExplain();
    }
}
