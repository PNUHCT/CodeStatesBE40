package com.codestates.cmarket.Controller;

import com.codestates.cmarket.order.Order;
import com.codestates.cmarket.order.OrderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderControllerImpl implements OrderController{

  private final OrderService orderService;

  public OrderControllerImpl(OrderService orderService) {
    this.orderService = orderService;
  }


  @Override
  @RequestMapping(value = "order", method = RequestMethod.GET)
  public String Order() {
    Order order = orderService.createOrder(0L, "coffee", 5000);
    return order.getItemName();
  }
}
