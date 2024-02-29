import java.util.Arrays;

//20240221 배열 데이터순서 변경
public class arrayPractice04 {
    public static void main(String[] args){
        int[] arr = {1, 3, 5, 7, 9};

        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }

        System.out.println(Arrays.toString(arr));
    }
}


