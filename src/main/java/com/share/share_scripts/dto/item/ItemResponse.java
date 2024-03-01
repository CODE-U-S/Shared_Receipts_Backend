package com.share.share_scripts.dto.item;

import com.share.share_scripts.domain.item.Item;
import com.share.share_scripts.domain.receipt.Receipt;
import lombok.Getter;

@Getter
public class ItemResponse {
    private Long id;
    private Receipt receipt;
    private String name;
    private Long price;
    private Integer count;

    public ItemResponse(Item item) {
        this.id = item.getId();
        this.receipt = item.getReceipt();
        this.name = item.getName();
        this.price = item.getPrice();
        this.count = item.getCount();
    }
}
