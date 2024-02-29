import java.util.Arrays;
    //20240221 배열의 데이터에 대해 짝수 평균과 홀수 평균 구하기
    public class arrayPractice02 {
        public static void main(String[] args){
            int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
            float sumEven = 0;
            float sumOdd = 0;
            int evenCnt = 0;
            int oddCnt = 0;

            for (int item : arr){
                if(item % 2 == 0){ //짝수
                    sumEven += item;
                    evenCnt++;
                }else { //홀수
                    sumOdd += item;
                    oddCnt++;
                }
            }

            System.out.println("짝수 평균 : " + sumEven / evenCnt);
            System.out.println("홀수 평균 : " + sumOdd / oddCnt);
        }
    }


