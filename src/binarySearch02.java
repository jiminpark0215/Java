import java.util.Arrays;

//알고리즘 - 이진 탐색 // 자바에서 제공하는 binarySearch
public class binarySearch02 {
    public static void main(String[] args){
        int[] arr = {1, 2, 5, 10, 20, 30, 40, 50, 60}; //정렬이 되어있어야 함


        System.out.println(" == 데이터가 있는 경우 == ");
        System.out.println(Arrays.binarySearch(arr, 1));
        System.out.println(Arrays.binarySearch(arr, 10));
        System.out.println(Arrays.binarySearch(arr, 30));

        System.out.println(" == 데이터가 없는 경우 == ");
        System.out.println(Arrays.binarySearch(arr, 3)); // 데이터가 없다면
        System.out.println(Arrays.binarySearch(arr, 11));
        System.out.println(Arrays.binarySearch(arr, 35));
    }
}