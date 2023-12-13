package com.share.share_scripts.repository.item;

import com.share.share_scripts.domain.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
