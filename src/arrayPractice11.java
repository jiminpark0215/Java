import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

//20240223
/*
intervals 라는 구간으로 이루어진 배열이 주어졋을 때,
오버랩되는 구간을 합치는 프로그램을 작성하세요.
합친 구간은 오름차순으로 정렬해서 반환하시오.
 */
public class arrayPractice11 {
    public static ArrayList<int[]> soulution(int[][] intervals) {
        if(intervals == null || intervals.length < 2){
            return new ArrayList<>();
        }

        sort(intervals);

        ArrayList<int[]> result = new ArrayList<>();
        int[] curInterval = intervals[0];
        result.add(curInterval);

        for (int i = 0; i < intervals.length; i++) {
            if (curInterval[1] >= intervals[i][0]){
                curInterval[1] = intervals[i][1];
            }else {
                curInterval = intervals[i];
                result.add(curInterval);
            }
        }
        return result;
    }

    public static void sort(int[][] intervals) {
        quickSort(intervals, 0, intervals.length-1);
    }

    public static void quickSort(int[][] arr, int left , int right) {
        if(left >= right){
            return;
        }
        int pivot = partition(arr, left, right);

        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot + 1, right);
    }

    public static int partition(int[][] arr, int left , int right){
        int pivot = arr[left][0];
        int i = left;
        int j = right;

        while (i < j){
            while (arr[j][0] > pivot && i < j){
                j--;
            }

            while (arr[i][0] <= pivot && i < j){
                i++;
            }

            swap(arr, i, j);
        }
        swap(arr, left, j);

        return i;
    }

    public static void swap(int[][] arr, int i , int j){
        int[] tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    public static void main(String[] args){
        int[][] intervals = {{2, 6}, {1, 3}, {15, 18}, {8, 10}};
        for(int[] item : soulution(intervals)){
            System.out.print(Arrays.toString(item) + " ");
        }
        System.out.println();
    }
}

