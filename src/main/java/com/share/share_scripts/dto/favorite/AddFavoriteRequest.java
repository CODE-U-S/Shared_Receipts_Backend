package com.share.share_scripts.dto.favorite;

import com.share.share_scripts.domain.favorite.Favorite;
import com.share.share_scripts.domain.link.Link;
import com.share.share_scripts.domain.post.Post;
import com.share.share_scripts.domain.user.User;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddFavoriteRequest {
    @NotNull
    private User user;

    @NotNull
    private Post post;

    public Favorite toEntity() {
        return Favorite.builder()
                .user(user)
                .post(post)
                .build();
    }
}
