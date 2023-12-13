package com.share.share_scripts.dto.item;

import com.share.share_scripts.domain.item.Item;
import com.share.share_scripts.domain.post.Post;
import com.share.share_scripts.domain.receipt.Receipt;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddItemRequest {
    private Receipt receiptNo;
    private String itemName;
    private Long itemPrice;
    private Integer itemCount;

    public Item toEntity() {
        return Item.builder()
                .receiptNo(receiptNo)
                .itemName(itemName)
                .itemPrice(itemPrice)
                .itemCount(itemCount)
                .build();
    }
}
