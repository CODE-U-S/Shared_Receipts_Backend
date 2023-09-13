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
    private User userNo;
    private Post postNo;

    public Favorite toEntity() {
        return Favorite.builder()
                .userNo(userNo)
                .postNo(postNo)
                .build();
    }
}
