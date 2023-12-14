package com.share.share_scripts.domain.post;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.share.share_scripts.domain.BaseTimeEntity;
import com.share.share_scripts.domain.favorite.Favorite;
import com.share.share_scripts.domain.link.Link;
import com.share.share_scripts.domain.receipt.Receipt;
import com.share.share_scripts.domain.user.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends BaseTimeEntity {
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

    @JsonIgnore
    @OneToMany(mappedBy = "postNo", cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true)
    private List<Receipt> receiptList;

    @JsonIgnore
    @OneToMany(mappedBy = "postNo", cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true)
    private List<Link> linkList;

    @JsonIgnore
    @OneToMany(mappedBy = "postNo", cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true)
    private List<Favorite> favoriteList;

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
