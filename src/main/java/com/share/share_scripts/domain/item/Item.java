package com.share.share_scripts.domain.item;

import com.share.share_scripts.domain.receipt.Receipt;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_no", updatable = false)
    private Long itemNo;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "receipt_no")
    private Receipt receiptNo;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "item_price")
    private Long itemPrice;

    @Column(name = "item_count")
    private Integer itemCount;

    @Builder
    public Item(Receipt receiptNo, String itemName, Long itemPrice, Integer itemCount) {
        this.receiptNo = receiptNo;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemCount = itemCount;
    }

    public void update(String itemName, Long itemPrice, Integer itemCount) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemCount = itemCount;
    }
}
