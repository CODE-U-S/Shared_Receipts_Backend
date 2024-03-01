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
    @Column(name = "id", updatable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Integer price;

    @JsonIgnore
    @OneToMany(mappedBy = "receipt", cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true)
    private List<Item> itemList;

    @Builder
    public Receipt(Post post, String name, Integer price) {
        this.post = post;
        this.name = name;
        this.price = price;
    }

    public void update(String name, Integer price) {
        this.name = name;
        this.price = price;
    }
}

