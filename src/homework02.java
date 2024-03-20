/*
처리일자 : 20240207
처리자 : 박지민

2번 과제 - 결제 금액 캐시백 계산 프로그램
 */
import java.util.Scanner;
public class homework02 {
    public static void main(String[] args) {
        Scanner cashScanner = new Scanner(System.in);

        System.out.println("[캐시백 계산]");
        System.out.println("결제 금액을 입력해 주세요.(금액): ");

        int payInput = cashScanner.nextInt();
        int cashBack = (int)((double)payInput * 0.1) > 300 ? 300 : ((int)((double)payInput * 0.1)/100) * 100;

        System.out.printf("결제 금액은 %d원이고, 캐시백은 %d원 입니다." , payInput , cashBack);
    }
}

