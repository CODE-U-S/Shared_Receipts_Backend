package com.share.share_scripts.controller.item;

import com.share.share_scripts.domain.item.Item;
import com.share.share_scripts.dto.item.AddItemRequest;
import com.share.share_scripts.dto.item.ItemResponse;
import com.share.share_scripts.dto.item.UpdateItemRequest;
import com.share.share_scripts.service.item.ItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/item")
public class ItemController {
    private final ItemService itemService;

    @PostMapping
    public ResponseEntity<Item> addItem(@Valid @RequestBody AddItemRequest request, BindingResult bindingResult) {
        Item savedItem = itemService.save(request, bindingResult);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedItem);
    }

    @GetMapping
    public ResponseEntity<List<ItemResponse>> findAllItem() {
        List<ItemResponse> item = itemService.findAll()
                .stream()
                .map(ItemResponse::new)
                .toList();

        return ResponseEntity.ok().body(item);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable Long id,
                                           @Valid @RequestBody UpdateItemRequest request,
                                           BindingResult bindingResult) {
        Item updatedItem = itemService.update(id, request, bindingResult);

        return ResponseEntity.ok()
                .body(updatedItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        itemService.delete(id);
        return ResponseEntity.ok().build();
    }
}
