import java.util.ArrayList;
import java.util.Arrays;

//20240223
/*
    nums 배열에 3가지 색으로 구분되는 데이터들이 들어 있다.
    0은 흰색, 1은 파랑, 2는 빨강이라고 할 때
    주어진 nums 배열에서 흰색부터 빨강 순으로 인접하게 정렬시킨 후 출력하는 프로그램을 작성하세요
 */
public class arrayPractice09 {
    public static void soulution(int[] arr) {
        if (arr == null || arr.length == 0){
            return;
        }

        int[] cntArr = new int[3];
        for (int i = 0; i < arr.length; i++) {
            cntArr[arr[i]]++; //해당 위치에 카운팅
        }

        int idx = 0;
        for (int i = 0; i < cntArr.length; i++) { //카운팅테이블 순회
            while (cntArr[i] > 0){
                arr[idx++] = i; //arr 배열의 위치에 값이 들어감
                cntArr[i] -= 1; // 카운팅값은 감소
            }
        }
    }

    public static void main(String[] args){
        int[] arr = {2, 0, 2, 1, 1, 0} ;
        soulution(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println();

        arr = new int[]{2, 0, 1} ;
        soulution(arr);
        System.out.println(Arrays.toString(arr));

    }
}

