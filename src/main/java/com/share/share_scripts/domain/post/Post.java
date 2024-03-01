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
    @Column(name = "id", updatable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "user_count")
    private Long userCount;

    @Column(name = "title")
    private String title;

    @Column(name = "tag")
    private String tag;

    @Column(name = "explain")
    private String explain;

    @JsonIgnore
    @OneToMany(mappedBy = "post", cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true)
    private List<Receipt> receiptList;

    @JsonIgnore
    @OneToMany(mappedBy = "post", cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true)
    private List<Link> linkList;

    @JsonIgnore
    @OneToMany(mappedBy = "post", cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true)
    private List<Favorite> favoriteList;

    @Builder
    public Post(User user, Long userCount, String title, String tag, String explain) {
        this.user = user;
        this.userCount = userCount;
        this.title = title;
        this.tag = tag;
        this.explain = explain;
    }

    public void update(Long userCount, String title, String tag, String explain) {
        this.userCount = userCount;
        this.title = title;
        this.tag = tag;
        this.explain = explain;
    }
}
