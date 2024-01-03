package com.share.share_scripts.dto.favorite;

import com.share.share_scripts.domain.favorite.Favorite;
import com.share.share_scripts.domain.post.Post;
import com.share.share_scripts.domain.user.User;
import lombok.Getter;

@Getter
public class FavoriteResponse {
    private Long favoriteNo;
    private User user;
    private Post post;

    public FavoriteResponse(Favorite favorite) {
        this.favoriteNo = favorite.getFavoriteNo();
        this.user = favorite.getUser();
        this.post = favorite.getPost();
    }
}
