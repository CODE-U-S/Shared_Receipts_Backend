package com.share.share_scripts.controller.item;

import com.share.share_scripts.domain.item.Item;
import com.share.share_scripts.dto.item.AddItemRequest;
import com.share.share_scripts.dto.item.ItemResponse;
import com.share.share_scripts.dto.item.UpdateItemRequest;
import com.share.share_scripts.service.item.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ItemController {
    private final ItemService itemService;

    @PostMapping("/api/item")
    public ResponseEntity<Item> addItem(@RequestBody AddItemRequest request) {
        Item savedItem = itemService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedItem);
    }

    @GetMapping("/api/item")
    public ResponseEntity<List<ItemResponse>> findAllItem() {
        List<ItemResponse> item = itemService.findAll()
                .stream()
                .map(ItemResponse::new)
                .toList();

        return ResponseEntity.ok().body(item);
    }

    @PutMapping("/api/item/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable Long id,
                                           @RequestBody UpdateItemRequest request) {
        Item updatedItem = itemService.update(id, request);

        return ResponseEntity.ok()
                .body(updatedItem);
    }

    @DeleteMapping("/api/item/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        itemService.delete(id);
        return ResponseEntity.ok().build();
    }
}
