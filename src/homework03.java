/*
처리일자 : 20240207
처리자 : 박지민

3번 과제 - 놀이동산 입장권 계산 프로그램
 */
import java.util.Scanner;

public class homework03 {
    public static void main(String[] args) {
        Scanner conditionScan = new Scanner(System.in);

        System.out.print("나이를 입력해 주세요.(숫자): " );
        int conAge = conditionScan.nextInt();

        System.out.print("입장시간을 입력해 주세요.(숫자입력): " );
        int conTime = conditionScan.nextInt();

        System.out.print("국가유공자 여부를 입력해 주세요.(y/n): " );
        char conMerit = conditionScan.next().trim().charAt(0);

        System.out.print("복지카드 여부를 입력해 주세요.(y/n): " );
        char conWelfare = conditionScan.next().trim().charAt(0);

        int ticketPrice = 0;
        if( conAge >= 0 && conAge < 3)  { //영유아 무료
            ticketPrice = 0;
        } else if (conMerit == 'y' || conWelfare == 'y') { //일반할인
            ticketPrice = 8000;
        } else if (conAge < 13 || conTime >= 17) { //특별 할인
            ticketPrice = 4000;
        } else {
            ticketPrice = 10000;
        }

        System.out.println("입장권: " + ticketPrice);
    }
}

