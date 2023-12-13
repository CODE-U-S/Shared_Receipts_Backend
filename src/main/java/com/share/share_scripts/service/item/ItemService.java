package com.share.share_scripts.service.item;

import com.share.share_scripts.domain.item.Item;
import com.share.share_scripts.dto.item.AddItemRequest;
import com.share.share_scripts.dto.item.UpdateItemRequest;
import com.share.share_scripts.repository.item.ItemRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public Item save(AddItemRequest request) {
        return itemRepository.save(request.toEntity());
    }

    public List<Item> findAll() { return itemRepository.findAll(); }

    public void delete(Long id) { itemRepository.deleteById(id); }

    @Transactional
    public Item update(Long id, UpdateItemRequest request) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));

        item.update(
                request.getItemName(),
                request.getItemPrice(),
                request.getItemCount()
        );

        return item;
    }
}
