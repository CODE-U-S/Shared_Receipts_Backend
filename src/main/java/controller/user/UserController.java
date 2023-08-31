package controller.user;

import domain.user.User;
import dto.user.AddUserRequest;
import dto.user.UpdateUserRequest;
import dto.user.UserResponse;
import lombok.RequiredArgsConstructor;
import org.hibernate.sql.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.user.UserService;

import java.util.List;

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

    // read
    @GetMapping("/api/users")
    public ResponseEntity<List<UserResponse>> findAllUsers() {
        List<UserResponse> users = userService.findAll()
                .stream()
                .map(UserResponse::new)
                .toList();

        return ResponseEntity.ok().body(users);
    }

    // update
    @PutMapping("/api/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id,
                                           @RequestBody UpdateUserRequest request) {
        User updatedUser = userService.update(request);

        return ResponseEntity.ok().body(updatedUser);
    }

    // delete
    @DeleteMapping("/api/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.delete(id);

        return ResponseEntity.ok().build();
    }
}
