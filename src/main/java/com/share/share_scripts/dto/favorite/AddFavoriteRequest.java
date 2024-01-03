package com.share.share_scripts.dto.favorite;

import com.share.share_scripts.domain.favorite.Favorite;
import com.share.share_scripts.domain.link.Link;
import com.share.share_scripts.domain.post.Post;
import com.share.share_scripts.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddFavoriteRequest {
    private User user;
    private Post post;

    public Favorite toEntity() {
        return Favorite.builder()
                .user(user)
                .post(post)
                .build();
    }
}
