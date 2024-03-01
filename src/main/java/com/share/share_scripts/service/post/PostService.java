package com.share.share_scripts.service.post;

import com.share.share_scripts.domain.post.Post;
import com.share.share_scripts.dto.post.AddPostRequest;
import com.share.share_scripts.dto.post.UpdatePostRequest;
import com.share.share_scripts.exception.PostNotFoundException;
import com.share.share_scripts.exception.UserNotFoundException;
import com.share.share_scripts.exception.handler.ErrorCode;
import com.share.share_scripts.repository.post.PostRepository;
import com.share.share_scripts.repository.user.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;

import static com.share.share_scripts.exception.BadRequestException.badRequestException;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public Post save(AddPostRequest request, BindingResult bindingResult) {
        badRequestException(bindingResult);

        userRepository.findById(request.getUser().getId())
                .orElseThrow(() -> new UserNotFoundException(ErrorCode.USER_NOT_FOUND));

        return postRepository.save(request.toEntity());
    }

    public List<Post> findAll() { return postRepository.findAll(); }

    public void delete(Long id) { postRepository.deleteById(id); }

    @Transactional
    public Post update(Long id, UpdatePostRequest request, BindingResult bindingResult) {
        badRequestException(bindingResult);

        Post post = postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException(ErrorCode.POST_NOT_FOUND));

        post.update(
                request.getUserCount(),
                request.getTitle(),
                request.getTag(),
                request.getExplain()
        );

        return post;
    }
}
