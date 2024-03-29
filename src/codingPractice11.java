import java.io.*;
import java.util.*;
/*

백준 1463

문제
정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.

X가 3으로 나누어 떨어지면, 3으로 나눈다.
X가 2로 나누어 떨어지면, 2로 나눈다.
1을 뺀다.
정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.

입력
첫째 줄에 1보다 크거나 같고, 106보다 작거나 같은 정수 N이 주어진다.

출력
첫째 줄에 연산을 하는 횟수의 최솟값을 출력한다.

 */

public class codingPractice11 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();
        
        int arr[] = new int[N + 1];
        arr[0] = arr[1] = 0;
        
        //3으로 나누거나, 2로 나누거나, 1을 빼는 세 가지 경우의 수를 상향식으로 처리
        for(int i = 2 ; i <= N ; i++){
            arr[i] = arr[i - 1] + 1;
            if(i % 2 == 0) arr[i] = Math.min(arr[i], arr[i/2] + 1);
            if(i % 3 == 0) arr[i] = Math.min(arr[i], arr[i/3] + 1);
        }
        System.out.print(arr[N]);

    }
}