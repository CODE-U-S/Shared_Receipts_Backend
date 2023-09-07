package com.share.share_scripts.controller.post;

import com.share.share_scripts.domain.post.Post;
import com.share.share_scripts.dto.post.AddPostRequest;
import com.share.share_scripts.dto.post.PostResponse;
import com.share.share_scripts.dto.post.UpdatePostRequest;
import com.share.share_scripts.service.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;

    @PostMapping("/api/post")
    public ResponseEntity<Post> addPost(@RequestBody AddPostRequest request) {
        Post savedPost = postService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedPost);
    }

    @GetMapping("/api/post")
    public ResponseEntity<List<PostResponse>> findAllPost() {
        List<PostResponse> post = postService.findAll()
                .stream()
                .map(PostResponse::new)
                .toList();

        return ResponseEntity.ok().body(post);
    }

    @PutMapping("/api/post/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id,
                                           @RequestBody UpdatePostRequest request) {
        Post updatedPost = postService.update(id, request);

        return ResponseEntity.ok()
                .body(updatedPost);
    }

    @DeleteMapping("/api/post/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        postService.delete(id);
        return ResponseEntity.ok()
                .build();
    }
}
