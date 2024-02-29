//20240221 배열 인덱스 출력
public class arrayPractice03 {
    public static void main(String[] args){
        int[] arr = {1, 1, 100, 1, 1, 1, 100};
        int target = 100;
        int idxMax = -1;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == target){
                if(i > idxMax){
                    idxMax = i;
                }
            }
        }
        if (idxMax >= 0){
            System.out.println(idxMax);
        }
    }
}


