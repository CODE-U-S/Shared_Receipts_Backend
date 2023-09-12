package com.share.share_scripts.dto.favorite;

import com.share.share_scripts.domain.post.Post;
import com.share.share_scripts.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UpdateFavoriteRequest {
    private User userNo;
    private Post postNo;
}
