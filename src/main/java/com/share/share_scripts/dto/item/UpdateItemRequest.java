package com.share.share_scripts.dto.item;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UpdateItemRequest {
    private String itemName;
    private Long itemPrice;
    private Integer itemCount;
}
