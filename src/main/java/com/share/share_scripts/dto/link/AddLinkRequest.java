package com.share.share_scripts.dto.link;

import com.share.share_scripts.domain.link.Link;
import com.share.share_scripts.domain.post.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddLinkRequest {
    private Post postNo;
    private String url;

    public Link toEntity() {
        return Link.builder()
                .postNo(postNo)
                .url(url)
                .build();
    }
}
