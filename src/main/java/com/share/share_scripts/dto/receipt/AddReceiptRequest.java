package com.share.share_scripts.dto.receipt;

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
public class AddReceiptRequest {
    @NotNull
    private Post post;

    @NotBlank
    private String name;

    @NotNull
    private Integer price;

    public Receipt toEntity() {
        return Receipt.builder()
                .post(post)
                .name(name)
                .price(price)
                .build();
    }
}
