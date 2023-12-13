package com.share.share_scripts.service.favorite;

import com.share.share_scripts.domain.favorite.Favorite;
import com.share.share_scripts.dto.favorite.AddFavoriteRequest;
import com.share.share_scripts.repository.favorite.FavoriteRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FavoriteService {
    private final FavoriteRepository favoriteRepository;

    public Favorite save(AddFavoriteRequest request) { return favoriteRepository.save(request.toEntity()); }

    public List<Favorite> findAll() { return favoriteRepository.findAll(); }

    public void delete(Long id) { favoriteRepository.deleteById(id); }
}
