package com.share.share_scripts.service.favorite;

import com.share.share_scripts.domain.favorite.Favorite;
import com.share.share_scripts.dto.favorite.AddFavoriteRequest;
import com.share.share_scripts.repository.favorite.FavoriteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FavoriteService {
    private final FavoriteRepository favoriteRepository;

    public Favorite save(AddFavoriteRequest request) { return favoriteRepository.save(request.toEntity()); }
}
