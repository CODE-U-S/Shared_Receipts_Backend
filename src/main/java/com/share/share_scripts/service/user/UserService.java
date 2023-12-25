package com.share.share_scripts.service.user;

import com.share.share_scripts.dto.user.UpdateUserRequest;
import com.share.share_scripts.exception.DuplicateException;
import com.share.share_scripts.exception.UserNotFoundException;
import com.share.share_scripts.exception.handler.ErrorCode;
import com.share.share_scripts.repository.user.UserRepository;
import com.share.share_scripts.domain.user.User;
import com.share.share_scripts.dto.user.AddUserRequest;
import com.share.share_scripts.service.BindingResultException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;


/**
 * TODO : user가 지금 로그인 된 상태인지 로그아웃되어 있는 상태인지 확인하기
 * 확인 후, 만약 로그인 된 상태 라면 delete 가능
 * 반대로 로그아웃 된 상태 라면 delete 불가능하도록 (delete 요청 시 405에러 발생시키기)
 */
@RequiredArgsConstructor
@Service
public class UserService extends BindingResultException {
    private final UserRepository userRepository;

    /**
     * 사용자 추가
     *
     * 201 OK : 추가 완료
     *
     * 400 Bad Request : 파라미터의 값이 빠져 있는 등 dto와 동일 하지 않을 경우
     * 409 Conflict : 중복된 아이디 일 경우
     *
     * @param request
     * @param bindingResult
     * @return User
     */
    public User save(AddUserRequest request, BindingResult bindingResult) {
        badRequestException(bindingResult);

        // 중복된 아이디 체크
        if(userRepository.existsByUserId(request.getUserId())) {
            throw new DuplicateException(ErrorCode.ID_DUPLICATE);
        }

        return userRepository.save(request.toEntity());
    }

    /**
     * 모든 사용자 조회
     *
     * 200 OK : 사용자 조회 완료
     *
     * @return List<User>
     */
    public List<User> findAll() { return userRepository.findAll(); }

    /**
     * 특정 사용자 조회
     *
     * 200 OK : 사용자 조회 완료
     *
     * 404 Not Found : 사용자가 존재 하지 않을 경우
     *
     * @param id
     * @return
     */
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(ErrorCode.USER_NOT_FOUND));
    }

    /**
     * 사용자 삭제
     *
     * 200 OK : 사용자 삭제 완료
     *
     * TODO : user가 지금 로그인 된 상태인지 로그아웃되어 있는 상태인지 확인하기
     *  * 확인 후, 만약 로그인 된 상태 라면 delete 가능
     *  * 반대로 로그아웃 된 상태 라면 delete 불가능하도록 (delete 요청 시 405에러 발생시키기)
     *
     * 404 Not Found : 사용자가 존재 하지 않을 경우
     * 405 METHOD_NOT_ALLOWED : 로그아웃 된 상태에서 delete 할 경우
     *
     * @param id
     */
    public void delete(Long id) {
        // 유저를 찾지 못했을 경우 404 에러 발생
        User user = userRepository.findById(id)
                        .orElseThrow(() -> new UserNotFoundException(ErrorCode.USER_NOT_FOUND));

        userRepository.deleteById(user.getUserNo());
    }

    /**
     * 사용자 정보 업데이트
     *
     * 200 OK : 사용자 정보 업데이트 성공
     *
     * 404 Not Found : 변경할 사용자를 찾지 못한 경우
     *
     * @param id
     * @param request
     * @param bindingResult
     * @return User
     */
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
}
