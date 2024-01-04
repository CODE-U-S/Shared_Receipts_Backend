package com.share.share_scripts.service.favorite;

import com.share.share_scripts.domain.favorite.Favorite;
import com.share.share_scripts.dto.favorite.AddFavoriteRequest;
import com.share.share_scripts.exception.PostNotFoundException;
import com.share.share_scripts.exception.UserNotFoundException;
import com.share.share_scripts.exception.handler.ErrorCode;
import com.share.share_scripts.repository.favorite.FavoriteRepository;
import com.share.share_scripts.repository.post.PostRepository;
import com.share.share_scripts.repository.user.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;

import static com.share.share_scripts.exception.BadRequestException.badRequestException;

@Service
@RequiredArgsConstructor
public class FavoriteService {
    private final FavoriteRepository favoriteRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public Favorite save(AddFavoriteRequest request, BindingResult bindingResult) {
        badRequestException(bindingResult);

        userRepository.findById(request.getUser().getUserNo())
                .orElseThrow(() -> new UserNotFoundException(ErrorCode.USER_NOT_FOUND));

        postRepository.findById(request.getPost().getPostNo())
                .orElseThrow(() -> new PostNotFoundException(ErrorCode.POST_NOT_FOUND));

        return favoriteRepository.save(request.toEntity());
    }
    public List<Favorite> findAll() { return favoriteRepository.findAll(); }

    public void delete(Long id) { favoriteRepository.deleteById(id); }
}
