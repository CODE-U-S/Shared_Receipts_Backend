package com.share.share_scripts.service.item;

import com.share.share_scripts.domain.item.Item;
import com.share.share_scripts.dto.item.AddItemRequest;
import com.share.share_scripts.dto.item.UpdateItemRequest;
import com.share.share_scripts.exception.ItemNotFoundException;
import com.share.share_scripts.exception.ReceiptNotFoundException;
import com.share.share_scripts.exception.handler.ErrorCode;
import com.share.share_scripts.repository.item.ItemRepository;
import com.share.share_scripts.repository.receipt.ReceiptRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;

import static com.share.share_scripts.exception.BadRequestException.badRequestException;

@RequiredArgsConstructor
@Service
public class ItemService {
    private final ItemRepository itemRepository;
    private final ReceiptRepository receiptRepository;

    public Item save(AddItemRequest request, BindingResult bindingResult) {
        badRequestException(bindingResult);

        receiptRepository.findById(request.getReceipt().getId())
                .orElseThrow(() -> new ReceiptNotFoundException(ErrorCode.RECEIPT_NOT_FOUND));

        return itemRepository.save(request.toEntity());
    }

    public List<Item> findAll() { return itemRepository.findAll(); }

    public void delete(Long id) { itemRepository.deleteById(id); }

    @Transactional
    public Item update(Long id, UpdateItemRequest request, BindingResult bindingResult) {
        badRequestException(bindingResult);

        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(ErrorCode.ITEM_NOT_FOUND));

        item.update(
                request.getName(),
                request.getPrice(),
                request.getCount()
        );

        return item;
    }
}
