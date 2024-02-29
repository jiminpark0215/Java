import java.util.Arrays;

//20240221 배열 오름차순 출력
public class arrayPractice06 {
    public static void main(String[] args){
        int[] arr = {5, 3, 1, 4, 6, 1};
        int[] visited = new int[arr.length];
        int visitCnt = 0;
        int minVal = Integer.MAX_VALUE;
        int minIdx = -1;

        while(visitCnt < arr.length){
            for (int i = 0; i < arr.length; i++) {
                if(arr[i] < minVal && visited[i] == 0){ //배열의 값이 minVal의 값보다 작으면서
                    minVal = arr[i]; // 이미 출력했던 데이터가 아니면 요기에 넣음
                    minIdx = i; //최소값으로 업데이트
                }
            }

            if(minIdx != 1){ //최소값의 인덱스가 아니면
                System.out.print(minVal + " ");
                visited[minIdx] = 1; //이미 출력했다고 치고
                visitCnt++; //카운팅
            }

            minVal = Integer.MAX_VALUE; //다시 최대값으로 초기화
            minIdx = -1; //초기화
        }

        System.out.println();
    }
}


