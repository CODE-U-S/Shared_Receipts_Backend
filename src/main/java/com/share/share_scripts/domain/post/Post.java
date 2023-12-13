package com.share.share_scripts.domain.post;

import com.share.share_scripts.domain.user.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_no", updatable = false)
    private Long postNo;

    @ManyToOne
    @JoinColumn(name = "user_no")
    private User userNo;

    @Column(name = "user_count", nullable = false)
    private Long userCount;

    @Column(name = "post_title", nullable = false)
    private String postTitle;

    @Column(name = "post_tag", nullable = false)
    private String postTag;

    @Column(name = "post_explain")
    private String postExplain;

    @Builder
    public Post(User userNo, Long userCount, String postTitle, String postTag, String postExplain) {
        this.userNo = userNo;
        this.userCount = userCount;
        this.postTitle = postTitle;
        this.postTag = postTag;
        this.postExplain = postExplain;
    }

    public void update(Long userCount, String postTitle, String postTag, String postExplain) {
        this.userCount = userCount;
        this.postTitle = postTitle;
        this.postTag = postTag;
        this.postExplain = postExplain;
    }
}
