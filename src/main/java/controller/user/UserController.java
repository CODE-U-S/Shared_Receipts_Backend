package controller.user;

import domain.user.User;
import dto.user.AddUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import service.user.UserService;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    // create
    @PostMapping("/api/users")
    public ResponseEntity<User> addUser(@ResponseBody AddUserRequest request) {
        User savedUser = userService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedUser);
    }


}
