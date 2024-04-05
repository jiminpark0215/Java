import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*

백준 2193

문제
0과 1로만 이루어진 수를 이진수라 한다. 이러한 이진수 중 특별한 성질을 갖는 것들이 있는데, 이들을 이친수(pinary number)라 한다. 이친수는 다음의 성질을 만족한다.

이친수는 0으로 시작하지 않는다.
이친수에서는 1이 두 번 연속으로 나타나지 않는다. 즉, 11을 부분 문자열로 갖지 않는다.
예를 들면 1, 10, 100, 101, 1000, 1001 등이 이친수가 된다. 하지만 0010101이나 101101은 각각 1, 2번 규칙에 위배되므로 이친수가 아니다.

N(1 ≤ N ≤ 90)이 주어졌을 때, N자리 이친수의 개수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N이 주어진다.

출력
첫째 줄에 N자리 이친수의 개수를 출력한다.

 */

public class codingPractice18 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        //N(1 ≤ N ≤ 90) 정수가 90자리 넘어가면 int 로 불가 -> long
        //dp (왜냐면 dp[1] dp[2]가 정해져있음
        long[] dp = new long[N+1]; //n자리 이친 수의 총 개수

        dp[0] = 0;
        dp[1] = 1;

        // dp[n] n자리 수 끝에 0이 오는 경우 + 1이 오는 경우를 더하면 된다.
        // n 자리에 0과 1 두 가지만 올 수 있다.
        // n 자리에 0이 들어 오면, 앞에 0과 1 둘 다 들어올 수 있다.
        // n 자리에 1이 들어 오면, 앞에 0만 들어올 수 있다.

        for(int i=2; i<=N; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println(dp[N]);
    }
}