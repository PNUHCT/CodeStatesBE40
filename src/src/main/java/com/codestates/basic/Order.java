package com.codestates.basic;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "ORDERS")
public class Order {
    @Id
    private Long orderId;

    private LocalDateTime createdAt;
}
