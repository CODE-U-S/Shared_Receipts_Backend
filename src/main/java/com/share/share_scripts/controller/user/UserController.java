package com.share.share_scripts.controller.user;

import com.share.share_scripts.dto.user.UpdateUserRequest;
import com.share.share_scripts.dto.user.UserResponse;
import com.share.share_scripts.service.user.UserService;
import com.share.share_scripts.domain.user.User;
import com.share.share_scripts.dto.user.AddUserRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    // create
    @PostMapping
    public ResponseEntity<User> addUser(@Valid @RequestBody AddUserRequest request) {
        User savedUser = userService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedUser);
    }

    // read
    @GetMapping
    public ResponseEntity<List<UserResponse>> findAllUsers() {
        List<UserResponse> users = userService.findAll()
                .stream()
                .map(UserResponse::new)
                .toList();

        return ResponseEntity.ok().body(users);
    }

    // update
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id,
                                           @RequestBody UpdateUserRequest request) {
        User updatedUser = userService.update(id, request);

        return ResponseEntity.ok().body(updatedUser);
    }

    // delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.delete(id);

        return ResponseEntity.ok().build();
    }
}
