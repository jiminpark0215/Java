//20240221 배열 중복값 제거한 새로운 배열 생성
public class arrayPractice07 {
    public static void main(String[] args){
        int[] arr = {1, 5, 3, 2, 2, 3, 1, 4, 1, 2, 3, 5};
        int[] arrResult = new int[arr.length]; //새로 만들 배열.
        int cnt = 0; //인덱스 관리용

        for (int i = 0; i < arr.length; i++) {
            boolean dupFlag = false; //중복여부 체크
            for (int j = 0; j < cnt; j++) { //중복되지 않도록 cnt까지 돌림
                if(arr[i] == arrResult[j]){
                    dupFlag = true;
                }
            }

            if (dupFlag == false){ //중복이 아니면
                arrResult[cnt++] = arr[i]; //새 배열에 담아둠
            }
        }

        for (int i = 0; i < cnt; i++) {
            System.out.print(arrResult[i] + "");
        }

        System.out.println();
    }
}


