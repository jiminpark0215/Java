/*
처리일자 : 20240213
처리자 : 박지민

7번 과제 - 로또 당첨 프로그램
 */
import java.util.*;

public class homework07 {
    public static void main(String[] args) {
        Scanner lottoScan = new Scanner(System.in);//입력받기 위해 선언

        System.out.println("[로또 당첨 프로그램]");

        int lotteryCnt;

        while(true) {
            System.out.print("총 진행할 투표수를 입력해 주세요. ");
            lotteryCnt = lottoScan.nextInt();
            if(lotteryCnt < 1 || lotteryCnt > 10){  //입력조건 : 1 ~ 10 사이의 정수
                System.out.println("1 ~ 10 사이의 수를 입력해 주세요");
                continue;
            }

            System.out.println();
            break;
        }

        lotteryPrint(lotteryCnt);

    }

    public static int[] lotteryMachine() { //로또번호 생성
        int[] lottoArray = new int[6];

        for (int i = 0; i < lottoArray.length; i++) {
            lottoArray[i] =(int)(Math.random()*45) + 1;
            for (int j = 0; j < i; j++) {
                if(lottoArray[i] == lottoArray[j]){ //중복체크
                    i--;
                }
            }
        }

        Arrays.sort(lottoArray);//오름차순으로 정렬하여 표시

        return lottoArray;
    }

    public static void lotteryPrint(int lotteryCnt) { //로또출력
        //입력한 개수만큼의 로또 개수 생성을 하기 위한 배열 선언
        ArrayList<int[]> lottoInputList = new ArrayList<int[]>();

        //로또의 룰은 6개의 숫자
        int[] lottoOutput = new int[6];

        //1개 이상의 출력결과에 알파벳을 부여
        char lottoChar = 'A';

        //구매한 로또 개수 만큼 로또 생성
        for (int i = 0; i < lotteryCnt; i++) {
            lottoInputList.add(lotteryMachine());
            lottoOutput = lottoInputList.get(i);

            for (int j = 0; j < 6; j++) {
                if(j==0){
                    System.out.printf("%c\t%02d," , (char)(lottoChar+i), lottoOutput[j]);
                }else if(j==5){
                    System.out.printf("%02d\n" , lottoOutput[j]);
                }else{
                    System.out.printf("%02d," , lottoOutput[j]);
                }
            }
        }

        System.out.println();

        System.out.println("[로또 발표]");

        //로또 당첨 번호 생성
        int[] winningLottery = new int[6];
        winningLottery = lotteryMachine();

        for (int i = 0; i < 6; i++) {
            if(i==0){
                System.out.printf("\t%02d,", winningLottery[i]);
            }else if(i==5){
                System.out.printf("%02d\n" , winningLottery[i]);
            }else{
                System.out.printf("%02d," , winningLottery[i]);
            }
        }

        System.out.println();

        System.out.println("[내 로또 결과]");
        //당첨 번호와 구매한 로또 번호를 비교하여 숫자 일치 여부 판단
        for (int i = 0; i < lotteryCnt; i++) {
            lottoInputList.add(lotteryMachine());
            lottoOutput = lottoInputList.get(i);

            int winningCnt = 0;

            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 6; k++) {
                    if(winningLottery[k] == lottoOutput[j]){ //당첨번호와 구매번호 비교
                        winningCnt++;
                    }
                }
            }

            for (int j = 0; j < 6; j++) {
                if(j==0){
                    System.out.printf("%c\t%02d," , (char)(lottoChar+i), lottoOutput[j]);
                }else if(j==5){
                    System.out.printf("%02d => %d개 일치\n" , lottoOutput[j], winningCnt); //일치하는 부분도 출력
                }else{
                    System.out.printf("%02d," , lottoOutput[j]);
                }
            }
        }
    }
}
