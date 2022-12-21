package com.codestates.entity_mapping.many_to_many;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(length = 100, nullable = false)
    private String korName;

    @Column(length = 100, nullable = false)
    private String engName;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(nullable = false, name = "LAST_MODIFIED_AT")
    private LocalDateTime modifiedAt = LocalDateTime.now();

    public Coffee(String korName, String engName, int price) {
        this.korName = korName;
        this.engName = engName;
        this.price = price;
    }

    @ManyToMany(mappedBy = "coffees")
    private List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        this.orders.add(order);
    }
}
