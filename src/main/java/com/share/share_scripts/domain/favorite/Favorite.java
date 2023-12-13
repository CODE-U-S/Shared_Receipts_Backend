package com.share.share_scripts.domain.favorite;

import com.share.share_scripts.domain.post.Post;
import com.share.share_scripts.domain.user.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "favorite_no", updatable = false)
    private Long favoriteNo;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "user_no")
    private User userNo;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "post_no")
    private Post postNo;

    @Builder
    public Favorite(User userNo, Post postNo) {
        this.userNo = userNo;
        this.postNo = postNo;
    }

    public void update(User userNo, Post postNo) {
        this.userNo = userNo;
        this.postNo = postNo;
    }
}