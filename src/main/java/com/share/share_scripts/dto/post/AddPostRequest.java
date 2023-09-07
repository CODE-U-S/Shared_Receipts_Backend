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
    private Long receiptCount;
    private String title;
    private String tag;
    private String explain;

    public Post toEntity() {
        return Post.builder()
                .userNo(userNo)
                .receiptCount(receiptCount)
                .title(title)
                .tag(tag)
                .explain(explain)
                .build();
    }
}
