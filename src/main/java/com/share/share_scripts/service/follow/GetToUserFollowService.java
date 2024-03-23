package com.share.share_scripts.service.follow;

import com.share.share_scripts.domain.user.User;
import com.share.share_scripts.dto.follow.FollowResponse;
import com.share.share_scripts.exception.UserNotFoundException;
import com.share.share_scripts.exception.handler.ErrorCode;
import com.share.share_scripts.repository.follow.FollowRepository;
import com.share.share_scripts.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class GetToUserFollowService {
    private final FollowRepository followRepository;
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<FollowResponse> execute(Long toUserId, User fromUser) {
        if(!userRepository.existsById(toUserId) || !userRepository.existsById(fromUser.getId())) throw new UserNotFoundException(ErrorCode.USER_NOT_FOUND);

        List<FollowResponse> follows = followRepository.findAllByToUser(toUserId)
                .stream()
                .map(FollowResponse::new)
                .collect(Collectors.toList());

        return follows;
    }
}