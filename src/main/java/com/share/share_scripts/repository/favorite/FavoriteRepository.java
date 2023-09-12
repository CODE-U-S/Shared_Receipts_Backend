package com.share.share_scripts.repository.favorite;

import com.share.share_scripts.domain.favorite.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
}
