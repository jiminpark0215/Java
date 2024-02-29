import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

//20240224
/*
백준 수 찾기 1920
*/
public class binarySearchPractice06 {
    public static int binarySearch(int[] array, int target){
        if (array == null || array.length == 0){
            return  -1;
        }

        int left = 0;
        int right = array.length - 1;

        while (left <= right){
            int mid = left + (right - left)/ 2;
            if (target == array[mid]){
                return mid;
            } else if (target < array[mid]) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        //일반적인 scanner 사용 버전
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] array = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = sc.nextInt();
        }

        Arrays.sort(array);

        int M = sc.nextInt();

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < M; i++) {
            if(binarySearch(array, sc.nextInt()) >= 0){
                stringBuilder.append(1).append("\n");
            }else {
                stringBuilder.append(0).append("\n");
            }
        }

        System.out.println(stringBuilder);

       /*

        //BufferedReader 사용 버전

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int inputDataN = Integer.parseInt(br.readLine()); //입력받음
        int[] array = new int[inputDataN]; //입력받은 값으로 배열 생성

        StringTokenizer st = new StringTokenizer(br.readLine()); //문자열 잘라냄

        for (int i = 0; i < inputDataN; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        //오름차순 정렬
        Arrays.sort(array);

        int inputDataM = Integer.parseInt(br.readLine()); //입력받음

        StringBuilder stringBuilder = new StringBuilder(); //결과 저장을 위함

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < inputDataM; i++) {
            int check = Arrays.binarySearch(array, Integer.parseInt(st.nextToken()));

            if (check >= 0){
                stringBuilder.append(1 + "\n");
            }else {
                stringBuilder.append(0 + "\n");
            }
        }

        System.out.println(stringBuilder);

        */
    }
}