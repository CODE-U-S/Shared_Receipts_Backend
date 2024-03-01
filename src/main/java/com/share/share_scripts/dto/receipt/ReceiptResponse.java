package com.share.share_scripts.dto.receipt;

import com.share.share_scripts.domain.post.Post;
import com.share.share_scripts.domain.receipt.Receipt;
import lombok.Getter;

@Getter
public class ReceiptResponse {
    private Long id;
    private Post post;
    private String name;
    private Integer price;

    public ReceiptResponse(Receipt receipt) {
        this.id = receipt.getId();
        this.post = receipt.getPost();
        this.name = receipt.getName();
        this.price = receipt.getPrice();
    }
}
