//package com.example.codemarket;
//
//
//import com.example.codemarket.discount.CurrentDiscountInfo;
//import com.example.codemarket.discount.RateDiscountInfo;
//import com.example.codemarket.order.Order;
//import com.example.codemarket.order.OrderService;
//import com.example.codemarket.user.User;
//import com.example.codemarket.user.UserGrade;
//import com.example.codemarket.user.UserService;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//public class OrderApp {
//
//  public static void main(String[] args) {
//
////    AppConfig appConfig = new AppConfig();
////    UserService userService = appConfig.userService();
////    OrderService orderService = appConfig.orderService();
//    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
//    UserService userService = ac.getBean(UserService.class);
//    OrderService orderService = ac.getBean(OrderService.class);
//
//    Long userId = 0L;
//    User user = new User(userId, "kimlucky", UserGrade.GRADE_1);
//    userService.signup(user);
//
//    Order order = orderService.createOrder(userId, "coffee", 5000);
//
//    System.out.println("order = " + order);
//
//  }
//}