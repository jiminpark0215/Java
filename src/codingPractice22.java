import java.util.*;
import java.io.*;
/*

백준 2747
문제
계단 오르기 게임은 계단 아래 시작점부터 계단 꼭대기에 위치한 도착점까지 가는 게임이다.

계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다. 즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있다.
연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다.
마지막 도착 계단은 반드시 밟아야 한다.
따라서 첫 번째 계단을 밟고 이어 두 번째 계단이나, 세 번째 계단으로 오를 수 있다. 하지만, 첫 번째 계단을 밟고 이어 네 번째 계단으로 올라가거나, 첫 번째, 두 번째, 세 번째 계단을 연속해서 모두 밟을 수는 없다.

각 계단에 쓰여 있는 점수가 주어질 때 이 게임에서 얻을 수 있는 총 점수의 최댓값을 구하는 프로그램을 작성하시오.

입력
입력의 첫째 줄에 계단의 개수가 주어진다.

둘째 줄부터 한 줄에 하나씩 제일 아래에 놓인 계단부터 순서대로 각 계단에 쓰여 있는 점수가 주어진다. 계단의 개수는 300이하의 자연수이고, 계단에 쓰여 있는 점수는 10,000이하의 자연수이다.

출력
첫째 줄에 계단 오르기 게임에서 얻을 수 있는 총 점수의 최댓값을 출력한다.

 */

public class codingPractice22 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] data = new int[n + 1];
        for(int i = 1; i < n + 1; i++) {
            data[i]  = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n + 1];

        if(n == 1) {
            dp[1] = data[1]; //한 계단 혹은 두 계단씩 오름

        }else if(n == 2) {
            dp[2] = data[2] + data[1]; //연속된 세 개의 계단 x (시작점 포함 x, 시작점 0)

        }else {
            dp[1] = data[1];
            dp[2] = data[2] + data[1];
            dp[3] = Math.max(data[1] + data[3], data[2] + data[3]); //마지막 계단

            for(int i = 4; i < n + 1; i++) {
                dp[i] = Math.max(dp[i - 3] + data[i] + data[i - 1], dp[i - 2] + data[i]); //두 계단 + 한 계단 오른 경우와 한 번에 두 계단 오른 경우
            }
        }

        System.out.println(dp[n]);

    }
}