package com.share.share_scripts.dto.post;

import com.share.share_scripts.domain.post.Post;
import com.share.share_scripts.domain.user.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddPostRequest {
    @NotNull
    private User user;

    private Long userCount;

    @NotBlank
    private String title;

    private String tag;

    private String explain;

    public Post toEntity() {
        return Post.builder()
                .user(user)
                .userCount(userCount)
                .title(title)
                .tag(tag)
                .explain(explain)
                .build();
    }
}
