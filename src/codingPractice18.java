import java.io.*;
/*

백준 1065

문제
어떤 양의 정수 X의 각 자리가 등차수열을 이룬다면, 그 수를 한수라고 한다. 등차수열은 연속된 두 개의 수의 차이가 일정한 수열을 말한다.
N이 주어졌을 때, 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 1,000보다 작거나 같은 자연수 N이 주어진다.

출력
첫째 줄에 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력한다.

 */

public class codingPractice18 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        int cnt=0;

        //입력받은 N이 1자리나 2자리일 경우 자릿수별 값들끼리 항상 등차수열이 성립되기 때문에 100 N이 100 이하면 N개 만큼 한수 존재.
        if(Integer.parseInt(N)<100){
            cnt = Integer.parseInt(N);
        }

        else{
            cnt = 99; //위에서 N이 100 이하일 경우를 나눠놨기 때문에 N이 100이상일 경우엔 99개를 미리 더해놓고 100 보다 큰 값에서 한수를 찾으면 된다.
            for(int i=100;i<=Integer.parseInt(N);i++){
                String str = String.valueOf(i);
                String[] arr = str.split("");

                int minus_1 = Integer.parseInt(arr[0]) - Integer.parseInt(arr[1]);
                int minus_2 = Integer.parseInt(arr[1]) - Integer.parseInt(arr[2]);

                if(minus_1 == minus_2){
                    cnt++;
                }

            }
        }

        System.out.println(cnt);

    }
}