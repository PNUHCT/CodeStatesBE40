package com.codestates.cmarket.order;


import com.codestates.cmarket.user.User;
import com.codestates.cmarket.user.UserRepository;
import com.codestates.cmarket.discount.DiscountInfo;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

  private final UserRepository userRepository;
  private final DiscountInfo discountInfo;

  public OrderServiceImpl(UserRepository userRepository, DiscountInfo discountInfo) {
    this.userRepository = userRepository;
    this.discountInfo = discountInfo;
  }

  @Override
  public Order createOrder(Long userId, String itemName, int itemPrice) {
    User user = userRepository.findByUserId(userId);
    int discountPrice = discountInfo.discount(user, itemPrice);

    return new Order(userId, itemName, itemPrice, discountPrice);
  }
}