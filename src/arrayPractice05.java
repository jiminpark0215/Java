import java.util.Arrays;

//20240221 배열 peek값 출력
public class arrayPractice05 {
    public static void main(String[] args){
        int[] arr = {3, 1, 2, 6, 2, 2, 5, 1, 9, 10, 1, 11};

        for (int i = 0; i < arr.length; i++) {
            if( i == 0 && arr[i] > arr[i + 1]){ //가장 첫번쨰 값이 peek값인지 확인
                System.out.print(arr[i] + " ");

            } else if (i == arr.length - 1 && arr[i] > arr[i - 1]) { //가장 끝자리 데이터가 앞자리보다 크면 peek값
                System.out.print(arr[i] + " ");

            } else {
                if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1] ) {
                    System.out.print(arr[i] + " ");

                }
            }
        }

        System.out.println();
    }
}


