package com.share.share_scripts.repository.follow;

import com.share.share_scripts.domain.follow.Follow;
import com.share.share_scripts.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FollowRepository extends JpaRepository<Follow, Long> {
    List<Follow> findAllByToUser(Long toUser);
    List<Follow> findAllByFromUser(User fromUser);
    void deleteByToUserAndFromUser(Long toUser, User fromUser);
    boolean existsByToUserAndFromUser(Long toUser, User fromUser);
}
