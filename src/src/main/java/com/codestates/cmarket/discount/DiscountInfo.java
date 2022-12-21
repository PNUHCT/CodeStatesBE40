package com.codestates.cmarket.discount;

import com.codestates.cmarket.user.User;

public interface DiscountInfo {

  int discount(User user, int price);
}