import java.util.Scanner;

public class Calculator {
  public static void main(String[] args) {
    System.out.println("===Java Calculator===");

    Scanner input = new Scanner(System.in);

        /*
            요구 사항에 따라 간단한 계산기를 만들어주세요.
            1. 사용자의 입력으로 첫 번째 숫자, 연산자, 두 번째 숫자를 받아야 합니다.
            2. 연산자의 종류는 +, -, *, / 입니다.
            3. 소수점 연산을 수행할 수 있어야 합니다.
            4. 연산 결과를 콘솔에 출력합니다.
        */

      System.out.println("Input first number");
      double num1=input.nextDouble();
      System.out.println("Input function");
      char oper=input.next().charAt(0); // 캐릭터 타입을 입력받을 수 있다.
      System.out.println("Input Last number");
      double num2=input.nextDouble(); // 실수타입 입력받기


      if (oper=='+') System.out.println(num1+num2);
      else if (oper=='-') System.out.println(num1-num2);
      else if (oper=='*') System.out.println(num1*num2);
      else if (oper=='/') System.out.println(num1/num2);
      else System.out.println("Wrong char");

//    double num1, num2 = 0;
////    String oper = "";
////    double result = 0;
////
////    System.out.print("첫 번째 숫자 : ");
////    num1 = input.nextDouble();
////    System.out.print("연산자 : ");
////    oper = input.next();
////    System.out.print("두 번째 숫자 : ");
////    num2 = input.nextDouble();
////
////    input.close();

    // if-else문
        /* if(oper.equals("+")) {
            System.out.println(num1 + "+" + num2 + "=" + (num1 + num2));
        } else if (oper.equals("-")) {
            System.out.println(num1 + "-" + num2 + "=" + (num1 - num2));
        } else if (oper.equals("*")) {
            System.out.println(num1 + "*" + num2 + "=" + (num1 * num2));
        } else if (oper.equals("/")) {
            System.out.println(num1 + "/" + num2 + "=" + (num1 / num2));
        } else {
            System.out.println("잘못된 입력입니다.");
        }*/

    // switch문
  //    switch (oper){
  //      case "+" :
  //        result = num1+num2;
  //        break;
  //      case "-" :
  //        result = num1-num2;
  //        break;
  //      case "*" :
  //        result = num1*num2;
  //        break;
  //      case "/" :
  //        result = num1/num2;
  //        break;
  //      default:
  //        System.out.println("잘못된 입력입니다.");
  //        break;
  //    }
  //    System.out.println("결과 : " + num1 + " " + oper + " " + num2 + " = " + result);
      System.out.println("end calculator");




  /*    1. 숫자값을 받으면, int Array로
        2. 연산자를 받으면, char Array로
        3.
   */


  //      if (X!=) System.out.println("연산자를 확인하세요");

  //      1. 여러값을 입력받을 수 있다. 반복문으로 받는다.
  //      2. 반복문으로 받은 값을 계산한다.
  //      3. 사용자가 다른 값을 입력하면, 피드백을 준다.
  }
}
