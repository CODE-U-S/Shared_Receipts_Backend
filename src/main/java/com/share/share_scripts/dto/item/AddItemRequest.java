package com.share.share_scripts.dto.item;

import com.share.share_scripts.domain.item.Item;
import com.share.share_scripts.domain.post.Post;
import com.share.share_scripts.domain.receipt.Receipt;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddItemRequest {
    @NotNull
    private Receipt receipt;

    @NotBlank
    private String name;

    @NotNull
    private Long price;

    @NotNull
    private Integer count;

    public Item toEntity() {
        return Item.builder()
                .receipt(receipt)
                .name(name)
                .price(price)
                .count(count)
                .build();
    }
}
