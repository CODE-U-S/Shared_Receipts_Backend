package com.share.share_scripts.controller.favorite;

import com.share.share_scripts.domain.favorite.Favorite;
import com.share.share_scripts.dto.favorite.AddFavoriteRequest;
import com.share.share_scripts.service.favorite.FavoriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class FavoriteController {
    private final FavoriteService favoriteService;

    @PostMapping("/api/favorite")
    public ResponseEntity<Favorite> addFavorite(@RequestBody AddFavoriteRequest request) {
        Favorite savedFavorite = favoriteService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedFavorite);
    }
}
