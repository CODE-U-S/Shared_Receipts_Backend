package com.share.share_scripts.domain.link;

import com.share.share_scripts.domain.post.Post;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Link {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "link_no", updatable = false)
    private Long linkNo;

    @ManyToOne
    @JoinColumn(name = "post_no", referencedColumnName = "post_no")
    private Post postNo;

    @Column(name = "url")
    private String url;

    @Builder
    public Link(Post postNo, String url) {
        this.postNo = postNo;
        this.url = url;
    }

    public void update(Post postNo, String url) {
        this.postNo = postNo;
        this.url = url;
    }
}
