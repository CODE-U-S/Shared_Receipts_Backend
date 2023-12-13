package com.share.share_scripts.service.post;

import com.share.share_scripts.domain.post.Post;
import com.share.share_scripts.dto.post.AddPostRequest;
import com.share.share_scripts.dto.post.UpdatePostRequest;
import com.share.share_scripts.repository.post.PostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    public Post save(AddPostRequest request) {
        return postRepository.save(request.toEntity());
    }

    public List<Post> findAll() { return postRepository.findAll(); }

    public void delete(Long id) { postRepository.deleteById(id); }

    @Transactional
    public Post update(Long id, UpdatePostRequest request) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));

        post.update(
                request.getUserCount(),
                request.getPostTitle(),
                request.getPostTag(),
                request.getPostExplain()
        );

        return post;
    }
}
