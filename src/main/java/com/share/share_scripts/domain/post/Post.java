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

    @Column(name = "receipt_count", nullable = false)
    private Long receiptCount;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "tag", nullable = false)
    private String tag;

    @Column(name = "explain")
    private String explain;

    @Builder
    public Post(User userNo, Long receiptCount, String title, String tag, String explain) {
        this.userNo = userNo;
        this.receiptCount = receiptCount;
        this.title = title;
        this.tag = tag;
        this.explain = explain;
    }

    public void update(User userNo, Long receiptCount, String title, String tag, String explain) {
        this.userNo = userNo;
        this.receiptCount = receiptCount;
        this.title = title;
        this.tag = tag;
        this.explain = explain;
    }
}
