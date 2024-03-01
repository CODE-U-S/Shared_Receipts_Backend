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
    @Column(name = "id", updatable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "receipt_id")
    private Receipt receipt;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Long price;

    @Column(name = "count")
    private Integer count;

    @Builder
    public Item(Receipt receipt, String name, Long price, Integer count) {
        this.receipt = receipt;
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public void update(String name, Long price, Integer count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }
}
