package com.share.share_scripts.dto.link;

import com.share.share_scripts.domain.link.Link;
import com.share.share_scripts.domain.post.Post;
import lombok.Getter;

import javax.swing.*;

@Getter
public class LinkResponse {
    private Long linkNo;
    private Post postNo;
    private String url;

    public LinkResponse(Link link) {
        this.linkNo = link.getLinkNo();
        this.postNo = link.getPostNo();
        this.url = link.getUrl();
    }
}
