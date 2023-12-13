package com.share.share_scripts.dto.item;

import com.share.share_scripts.domain.favorite.Favorite;
import com.share.share_scripts.domain.item.Item;
import com.share.share_scripts.domain.receipt.Receipt;
import lombok.Getter;

@Getter
public class ItemResponse {
    private Long itemNo;
    private Receipt receiptNo;
    private String itemName;
    private Long itemPrice;
    private Integer itemCount;

    public ItemResponse(Item item) {
        this.itemNo = item.getItemNo();
        this.receiptNo = item.getReceiptNo();
        this.itemName = item.getItemName();
        this.itemPrice = item.getItemPrice();
        this.itemCount = item.getItemCount();
    }
}
