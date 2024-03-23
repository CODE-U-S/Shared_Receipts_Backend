package com.share.share_scripts.domain.follow;

import com.share.share_scripts.domain.user.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Follow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "to_user")
    private Long toUser;

    @ManyToOne
    @JoinColumn(name = "from_user")
    private User fromUser;

    @Builder
    public Follow(Long toUser, User fromUser) {
        this.toUser = toUser;
        this.fromUser = fromUser;
    }
}
