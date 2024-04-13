import java.io.*;
import java.util.*;
/*

백준 4344

문제
대학생 새내기들의 90%는 자신이 반에서 평균은 넘는다고 생각한다. 당신은 그들에게 슬픈 진실을 알려줘야 한다.

입력
첫째 줄에는 테스트 케이스의 개수 C가 주어진다.

둘째 줄부터 각 테스트 케이스마다 학생의 수 N(1 ≤ N ≤ 1000, N은 정수)이 첫 수로 주어지고, 이어서 N명의 점수가 주어진다. 점수는 0보다 크거나 같고, 100보다 작거나 같은 정수이다.

출력
각 케이스마다 한 줄씩 평균을 넘는 학생들의 비율을 반올림하여 소수점 셋째 자리까지 출력한다. 정답과 출력값의 절대/상대 오차는 10-3이하이면 정답이다.

 */

public class codingPractice23 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] arr;
        int sum, count;
        // 테스트케이스 개수 C
        int C = Integer.parseInt(br.readLine());
        for (int i = 0; i < C; i++) {
            // 각 점수를 더할 sum과 평균을 넘는 학생의 수 count를 0으로 초기화한다.
            sum = 0;
            count = 0;
            st = new StringTokenizer(br.readLine());
            // 학생의 수 N
            int N = Integer.parseInt(st.nextToken());
            // 학생의 수만큼 배열을 만든다.
            arr = new int[N];
            // 학생의 점수를 배열에 넣은 후 sum에 더한다.
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                sum += arr[j];
            }

            // 평균값 average
            float average = (float) sum / N;

            // 평균보다 높은 점수를 가진 학생의 수를 센다.
            for (int j = 0; j < N; j++) {
                if (average < arr[j]) count++;
            }

            // 평균을 넘는 학생들의 비율을 반올림한 number
            double number = Math.round((float) count / N * 100000);


            // number의 나머지가 0.0인지 아닌지 확인한다.
            if (number % 10 == 0.0) {
                // 0.0이면 소수점 3째자리까지 표현해야하므로 String.format으로 다시 비율을 구한다.
                System.out.println(String.format("%.3f%%", (float) count / N * 100));
            } else {
                // 나머지가 0.0이 아니라면 number에다가 %를 붙여서 끝낸다.
                System.out.println((number/1000) + "%");
            }
        }
    }
}