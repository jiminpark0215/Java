/*
처리일자 : 20240203
처리자 : 박지민

1번 과제 - 콘솔 화면에 구구단 출력하기
 */
public class homework01 {
    public static void main(String[] args) {
        System.out.println("[구구단 출력]");

        int [][] googooArray = new int[10][10];//구구단표
        int googooNum = 0;//구구단 값 대입
        int x,y;
        //저장
        for (x = 1; x < googooArray.length; x++) {
            for (y = 1; y < googooArray[x].length; y++) {
                googooArray[x][y] = googooNum++;
            }
        }

        //출력
        for (x = 1; x < googooArray.length; x++) {
            for (y = 1; y < googooArray[x].length; y++) {
                System.out.print(String.format("%02d", y) + " x " + String.format("%02d", x) + " = "  + String.format("%02d", x * y ) + " \t");
            }
            System.out.println();
        }
    }
}
