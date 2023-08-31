package com.share.share_scripts.service.user;

import com.share.share_scripts.repository.user.UserRepository;
import com.share.share_scripts.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public User loadUserByUsername(String userId) {
        return userRepository.findByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException(userId));
    }
}
