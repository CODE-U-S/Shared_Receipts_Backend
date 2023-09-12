package com.share.share_scripts.controller.favorite;

import com.share.share_scripts.domain.favorite.Favorite;
import com.share.share_scripts.dto.favorite.AddFavoriteRequest;
import com.share.share_scripts.dto.favorite.FavoriteResponse;
import com.share.share_scripts.service.favorite.FavoriteService;
import lombok.Generated;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/api/favorite")
    public ResponseEntity<List<FavoriteResponse>> findAllFavorite() {
        List<FavoriteResponse> favorite = favoriteService.findAll()
                .stream()
                .map(FavoriteResponse::new)
                .toList();

        return ResponseEntity.ok().body(favorite);
    }
}
