/*
처리일자 : 20240207
처리자 : 박지민

4번 과제 - 주민등록번호 생성 프로그램
 */
import java.util.Scanner;

public class homework04 {
    public static void main(String[] args) {
        Scanner residentInfoScan = new Scanner(System.in);

        System.out.print("출생년도를 입력해 주세요.(yyyy): " );
        int resiYear = residentInfoScan.nextInt();

        System.out.print("출생월을 입력해 주세요.(mm): " );
        int resiMonth = residentInfoScan.nextInt();

        System.out.print("출생일을 입력해 주세요.(dd): " );
        int resiDay = residentInfoScan.nextInt();

        System.out.print("성별을 입력해 주세요.(m/f): " );
        char resiGender = residentInfoScan.next().trim().charAt(0);

        ResidentNumberMaker(resiYear, resiMonth, resiDay, resiGender);
    }

    static void ResidentNumberMaker(int resiYear, int resiMonth, int resiDay, char resiGender){
        //문자열 배열에 추가
        StringBuilder newResidentNumber = new StringBuilder();
        double randomMath = Math.random();
        int randomNum = (int)(randomMath * 999999)+1; //생년월일 성별 임의번호

        newResidentNumber.append(Integer.toString(resiYear).substring(2,4));
        newResidentNumber.append(String.format("%02d",resiMonth));
        newResidentNumber.append(String.format("%02d",resiDay));

        newResidentNumber.append("-");

        if(resiGender == 'm' && resiYear < 2000) {
            newResidentNumber.append(Integer.toString(1));
        } else if (resiGender == 'f' && resiYear < 2000){
            newResidentNumber.append(Integer.toString(2));
        } else if (resiGender == 'm' && resiYear >= 2000){
            newResidentNumber.append(Integer.toString(3));
        } else if (resiGender == 'f' && resiYear >= 2000) {
            newResidentNumber.append(Integer.toString(4));
        }
        newResidentNumber.append(Integer.toString(randomNum));

        System.out.println(newResidentNumber);
    }
}

