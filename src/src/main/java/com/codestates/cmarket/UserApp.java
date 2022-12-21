//package com.example.codemarket;
//
//
//import com.example.codemarket.user.User;
//import com.example.codemarket.user.UserGrade;
//import com.example.codemarket.user.UserService;
//import com.example.codemarket.user.UserServiceImpl;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//public class UserApp {
//
//  public static void main(String[] args) {
////    UserService userService = new UserServiceImpl();
////    AppConfig appConfig = new AppConfig();
////    UserService userService = appConfig.userService();
//    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
//    UserService userService = ac.getBean("userService", UserService.class);
//
//    User user = new User(0L, "kimcoding", UserGrade.GRADE_2);
//    userService.signup(user);
//
//    User currentUser = userService.findUser(0L);
//    System.out.println("signup user : " + user.getName());
//    System.out.println("current user : " + currentUser.getName());
//
//    if(user.getName().equals(currentUser.getName())) {
//      System.out.println("새롭게 가입한 사용자와 현재 사용자가 같습니다.");
//    }
//  }
//}