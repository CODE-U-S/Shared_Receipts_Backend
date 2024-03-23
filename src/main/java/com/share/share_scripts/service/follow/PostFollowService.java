package com.share.share_scripts.service.follow;

import com.share.share_scripts.domain.user.User;
import com.share.share_scripts.dto.follow.AddFollowRequest;
import com.share.share_scripts.exception.FollowDuplicateException;
import com.share.share_scripts.exception.UserDuplicateException;
import com.share.share_scripts.exception.UserNotFoundException;
import com.share.share_scripts.exception.handler.ErrorCode;
import com.share.share_scripts.repository.follow.FollowRepository;
import com.share.share_scripts.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostFollowService {
    private final FollowRepository followRepository;
    private final UserRepository userRepository;

    @Transactional
    public void execute(AddFollowRequest request) {
        Long toUserId = request.getToUser();
        User fromUser = request.getFromUser();
        if(!userRepository.existsById(toUserId) || !userRepository.existsById(fromUser.getId())) throw new UserNotFoundException(ErrorCode.USER_NOT_FOUND);
        if(followRepository.existsByToUserAndFromUser(toUserId, fromUser) || (toUserId == fromUser.getId())) throw new FollowDuplicateException(ErrorCode.FOLLOW_DUPLICATE);

        followRepository.save(request.toEntity(toUserId, fromUser));
    }
}