package com.share.share_scripts.dto.receipt;

import com.share.share_scripts.domain.post.Post;
import com.share.share_scripts.domain.receipt.Receipt;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddReceiptRequest {
    private Post postNo;
    private String name;
    private Integer price;

    public Receipt toEntity() {
        return Receipt.builder()
                .postNo(postNo)
                .name(name)
                .price(price)
                .build();
    }
}
