package com.share.share_scripts.controller.favorite;

import com.share.share_scripts.domain.favorite.Favorite;
import com.share.share_scripts.dto.favorite.AddFavoriteRequest;
import com.share.share_scripts.dto.favorite.FavoriteResponse;
import com.share.share_scripts.service.favorite.FavoriteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/favorite")
public class FavoriteController {
    private final FavoriteService favoriteService;

    @PostMapping
    public ResponseEntity<Favorite> addFavorite(@Valid @RequestBody AddFavoriteRequest request, BindingResult bindingResult) {
        Favorite savedFavorite = favoriteService.save(request, bindingResult);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedFavorite);
    }

    @GetMapping
    public ResponseEntity<List<FavoriteResponse>> findAllFavorite() {
        List<FavoriteResponse> favorite = favoriteService.findAll()
                .stream()
                .map(FavoriteResponse::new)
                .toList();

        return ResponseEntity.ok().body(favorite);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFavorite(@PathVariable Long id) {
        favoriteService.delete(id);
        return ResponseEntity.ok()
                .build();
    }
}
