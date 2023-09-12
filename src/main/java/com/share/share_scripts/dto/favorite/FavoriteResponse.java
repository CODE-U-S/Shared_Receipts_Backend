package com.share.share_scripts.dto.favorite;

import com.share.share_scripts.domain.favorite.Favorite;
import com.share.share_scripts.domain.post.Post;
import com.share.share_scripts.domain.user.User;
import lombok.Getter;

@Getter
public class FavoriteResponse {
    private Long favoriteNo;
    private User userNo;
    private Post postNo;

    public FavoriteResponse(Favorite favorite) {
        this.favoriteNo = favorite.getFavoriteNo();
        this.userNo = favorite.getUserNo();
        this.postNo = favorite.getPostNo();
    }
}
