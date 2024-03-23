package com.share.share_scripts.service.follow;

import com.share.share_scripts.domain.user.User;
import com.share.share_scripts.exception.FollowNotFoundException;
import com.share.share_scripts.exception.UserNotFoundException;
import com.share.share_scripts.exception.handler.ErrorCode;
import com.share.share_scripts.repository.follow.FollowRepository;
import com.share.share_scripts.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DeleteFollowService {
    private final FollowRepository followRepository;
    private final UserRepository userRepository;

    @Transactional
    public void execute(Long toUserId, User fromUser) {
        if(!userRepository.existsById(toUserId) || !userRepository.existsById(fromUser.getId())) throw new UserNotFoundException(ErrorCode.USER_NOT_FOUND);
        if(!followRepository.existsByToUserAndFromUser(toUserId, fromUser)) throw new FollowNotFoundException(ErrorCode.FOLLOW_NOT_FOUND);
        followRepository.deleteByToUserAndFromUser(toUserId, fromUser);
    }
}