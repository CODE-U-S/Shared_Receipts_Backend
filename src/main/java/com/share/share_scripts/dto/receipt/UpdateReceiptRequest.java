package com.share.share_scripts.dto.receipt;

import com.share.share_scripts.domain.post.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UpdateReceiptRequest {
    private Post postNo;
    private String name;
    private Integer price;
}
