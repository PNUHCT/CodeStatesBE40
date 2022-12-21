package com.codestates.cmarket.order;


public interface OrderService {

  Order createOrder(Long userId, String itemName, int itemPrice);
}