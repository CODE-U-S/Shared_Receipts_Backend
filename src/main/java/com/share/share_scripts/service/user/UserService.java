package com.share.share_scripts.service.user;

import com.share.share_scripts.dto.user.UpdateUserRequest;
import com.share.share_scripts.exception.BadRequestException;
import com.share.share_scripts.exception.DuplicateException;
import com.share.share_scripts.exception.UserNotFoundException;
import com.share.share_scripts.exception.handler.ErrorCode;
import com.share.share_scripts.repository.user.UserRepository;
import com.share.share_scripts.domain.user.User;
import com.share.share_scripts.dto.user.AddUserRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    // create
    public User save(AddUserRequest request, BindingResult bindingResult) {
        badRequestException(bindingResult);

        // 중복된 아이디 체크
        if(userRepository.existsByUserId(request.getUserId())) {
            throw new DuplicateException(ErrorCode.ID_DUPLICATE);
        }

        return userRepository.save(request.toEntity());
    }

    // read
    public List<User> findAll() { return userRepository.findAll(); }

    // delete
    public void delete(Long id) {
        // 유저를 찾지 못했을 경우 404 에러 발생
        User user = userRepository.findById(id)
                        .orElseThrow(() -> new UserNotFoundException(ErrorCode.USER_NOT_FOUND));

        userRepository.deleteById(user.getUserNo());
    }

    // update
    @Transactional
    public User update(Long id, UpdateUserRequest request, BindingResult bindingResult) {
        badRequestException(bindingResult);

        // 유저를 찾지 못했을 경우 404 에러 발생
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(ErrorCode.USER_NOT_FOUND));

        user.update(
                request.getUserName(),
                request.getUserPw(),
                request.getUserGender(),
                request.getUserImg()
        );

        return user;
    }

    private void badRequestException(BindingResult bindingResult) {
        if(bindingResult.hasErrors()) throw new BadRequestException(ErrorCode.BAD_REQUEST);
    }
}
