package com.share.share_scripts.dto.receipt;

import com.share.share_scripts.domain.post.Post;
import com.share.share_scripts.domain.receipt.Receipt;
import lombok.Getter;

@Getter
public class ReceiptResponse {
    private Long receiptNo;
    private Post postNo;
    private String name;
    private Integer price;

    public ReceiptResponse(Receipt receipt) {
        this.receiptNo = receipt.getReceiptNo();
        this.postNo = receipt.getPostNo();
        this.name = receipt.getName();
        this.price = receipt.getPrice();
    }
}
