package com.share.share_scripts.dto.receipt;

import com.share.share_scripts.domain.post.Post;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UpdateReceiptRequest {
    @NotBlank
    private String name;

    @NotNull
    private Integer price;
}
