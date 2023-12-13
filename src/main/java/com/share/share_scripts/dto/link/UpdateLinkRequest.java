package com.share.share_scripts.dto.link;

import com.share.share_scripts.domain.post.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UpdateLinkRequest {
    private String url;
}
