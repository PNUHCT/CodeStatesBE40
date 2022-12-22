package com.codestates.seb.kdelivery;

import java.util.Scanner;

// 클래스를 정의 합니다.
public class KDeliveryMain {
  /**
   * 음식점 등록 개수, 음식 주문 가능 횟수, 리뷰 등록 가능 횟수 정의
   * */
  private static int SHOP_MAX = 5;
  private static int ORDER_MAX= 5;
  private static int FEEDBACK_MAX = ORDER_MAX;


  /**
   * 배열을 담을 수 있는 객체 생성
   * 사용 범위, 객체 타입, 객체 이름
   */
  private Shop[] shops;
  private Order[] orders;
  private Feedback[] feedbacks;

  // 해당 변수를 제어하는 Idx변수를 정의하고 초기화


  private Scanner s; // 사용자의 입력을 받는 객체 생성

  /**
   * @KDeliveryMainV1() : 매장 정보, 주문 정보, 리뷰 정보 초기화
   * initValues() 메서드 사용
   * */


  /**
   * @initValues() : 객체에 저장될 수 있는 크기 지정
   * SHOP_MAX, ORDER_MAX, FEEDBACK_MAX = 5
   * */


  /**
   * @close() : 프로그램 종료를 위해 사용되는 메서드
   * 사용자가 종료를 선언하면 동작합니다.
   * main()에서 활용됩니다.
   * */


  /**
   * selectMainMenu() : 기능을 나열하며, 사용자가 원하는 기능을 정수로 받습니다.
   * */

  /**
   * @selectAddShopMenu() : 음식점의 정보를 등록합니다.
   * @shops   : 가게 정보를 저장합니다.
   * @shopIdx : 가게 정보의 인덱스
   * */

  public void selectAddShopMenu() {

    /**
     * @Shop.java 의 Shop 클래스를 활용한 객체 생성
     * @public 클래스 : 동일 패키지 및 다른 패키지에서 사용가능
     * @addFood() : Shop.java 의 Shop 클래스의 addFood() 메서드
     * 해당 메서드는 매장명, 음식명, 가격을 입력받아 객체에 저장
     * 값이 저장될 때 마다 shopIdx 값 증가
     */

  }

  /**
   * @selectDashboardMenu() : 해당 메서드는 등록된 가게 정보를 출력합니다.
   * Feedback.java 파일의 클래스 및 메서드를 활용합니다.
   * */


  /**
   * @selectOrderMenu() : 주문 기능
   * 사용자의 입력을 받아 orders 객체에 저장
   * */

  /**
   * @selectFeedbackMenu() : 메뉴의 피드백을 입력받는 기능
   * */

  public static void main(String[] args) {

  }
}