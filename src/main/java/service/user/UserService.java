package service.user;

import domain.user.User;
import dto.user.AddUserRequest;
import dto.user.UpdateUserRequest;
import dto.user.UserResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.user.UserRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    // create
    public User save(AddUserRequest request) { return userRepository.save(request.toEntity()); }

    // read
    public List<User> findAll() { return userRepository.findAll(); }

    // delete
    public void delete(Long id) { userRepository.deleteById(id); }

    // update
    @Transactional
    public User update(Long id, UpdateUserRequest request) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));

        user.update(
                request.getUserName(),
                request.getUserId(),
                request.getUserPw(),
                request.getUserEmail(),
                request.getUserPhone(),
                request.getUserBirth(),
                request.getUserGender(),
                request.getUserImg()
        );

        return user;
    }

    public Long signUpUser(AddUserRequest dto) {
        return userRepository.save(User.builder()
                .userId(dto.getUserId())
                .userPw(dto.getUserPw())
                .build()
        ).getUserNo();
    }
}
