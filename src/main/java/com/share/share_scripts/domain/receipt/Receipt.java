package com.share.share_scripts.domain.receipt;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.share.share_scripts.domain.item.Item;
import com.share.share_scripts.domain.post.Post;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "receipt_no", updatable = false)
    private Long receiptNo;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "post_no")
    private Post postNo;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Integer price;

    @JsonIgnore
    @OneToMany(mappedBy = "receiptNo", cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true)
    private List<Item> itemList;

    @Builder
    public Receipt(Post postNo, String name, Integer price) {
        this.postNo = postNo;
        this.name = name;
        this.price = price;
    }

    public void update(Post postNo, String name, Integer price) {
        this.postNo = postNo;
        this.name = name;
        this.price = price;
    }
}

