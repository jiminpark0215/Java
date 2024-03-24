/*
처리일자 : 20230205
처리자 : 박지민

5번 과제 - 달력 출력 프로그램
 */
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class homework05 {
    public static void main(String[] args) {
        System.out.println("[달력 출력 프로그램]");
        Scanner calScan = new Scanner(System.in);//입력받기 위해 선언

        System.out.print("달력의 년도를 입력해 주세요.(yyyy): ");
        int calYear = calScan.nextInt();
        System.out.print("달력의 월을 입력해 주세요.(mm): ");
        int calMonth = calScan.nextInt();

        printCalendar(calYear , calMonth);
    }

    static void printCalendar(int calYear, int calMonth) {
        Calendar myCal = Calendar.getInstance(); //칼린더를 사용할 준비
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyymmdd"); //날짜포맷클래스

        int weekDay = myCal.get(Calendar.DAY_OF_WEEK); //해당 월이 시작되는 요일
        int lastDay = myCal.getActualMaximum(Calendar.DATE); //해당 월의 마지막 일자

        //입력받은 자료의 전월 지정
        int preYear = calYear;
        int preMonth = calMonth - 1;

        if (preMonth == -1) {
            preMonth = 11;
            preMonth--;
        } else if (calMonth == 1) {
            preMonth = 13;
            preMonth--;
            preYear--;
        }

        //입력받은 자료의 현재달 지정
        int nowYear = myCal.get(Calendar.YEAR);
        int nowMonth = myCal.get(Calendar.MONTH)+1;

        //출력하고 배열에 담는 메소드 호출
        createCalendar(myCal, preYear, preMonth);
        createCalendar(myCal, calYear, calMonth);
        createCalendar(myCal, nowYear, nowMonth);

    }

    static void createCalendar(Calendar myCal, int calYear, int calMonth) {

        //입력받은 자료로 년월 지정
        myCal.set(Calendar.YEAR, calYear);
        myCal.set(Calendar.MONTH, calMonth);
        myCal.set(calYear, calMonth - 1, 1); //0부터 1월이 시작

        int weekDay = myCal.get(Calendar.DAY_OF_WEEK);//날짜의 요일
        int lastDay = myCal.getActualMaximum(Calendar.DATE);//월의 마지막날

        System.out.println("[" + calYear + "년 " + calMonth + "월]"); //년월의 타이틀
        System.out.println("일\t월\t화\t수\t목\t금\t토"); //요일명

        for (int x = 1; x <= lastDay; x++) {
            if (x == 1) {
                for (int y = 1; y < weekDay; y++) { // 처음 1일이 시작되는 요일 전까지 공백 맞추기
                    System.out.print("\t");
                }
            }
            System.out.print(String.format("%02d", x) + "\t"); //일자 전부 출력
            if (weekDay % 7 == 0) { //7일 단위로 끊음
                System.out.println();
            }
            weekDay++; //for문 돌림
        }
        System.out.println("\n");
    }
}

