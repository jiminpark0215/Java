//
/*

N명의 아이들이 한 줄로 서있다.
각각의 아이들은 점수 표를 가지고 있는데, 점수 표에 따라 다음과 같은 규칙으로 사탕을 나누어 줘야 한다.

적어도 1개 이상의 사탕을 나누어줘야 한다.
점수가 높은 아이에게는 바로 옆의 아이 보다는 사탕을 많이 줘야 한다.

N명의 아이들에 대한 점수 표가 ratings 배열에 주어질 때
나누어줘야하는 최소한의 사탕 개수를 출력하세요.

*/

public class javaBasicPractice10 {
    public static int solution(int[] ratings){
        if(ratings == null || ratings.length == 0){
            return 0;
        }

        int result = 1;
        int upCnt = 1;
        int downCnt = 0;
        int peak = 0;

        for (int i = 1; i < ratings.length; i++) {
            if(ratings[i] > ratings [i-1]){ //순방향쪽으로 비교해서 증가
                upCnt++;
                peak = upCnt;
                downCnt = 0;
                result += upCnt;

            } else if (ratings[i] == ratings[i-1]) { //같은 경우
                upCnt = 1;
                downCnt = 0; //초기화
                peak = 0; //초기화
                result += 1;

            }else {
                downCnt++;
                upCnt = 1;
                result += downCnt;

                if(peak <= downCnt){ //피크치를 넘어섰을 때
                    result += 1;
                }
            }
        }

        return result;
    }

    public static void main(String[] args){
        int[] ratings = {1, 2, 3};
        System.out.println(solution(ratings));

        ratings = new int[]{3, 2, 1};
        System.out.println(solution(ratings));

        ratings = new int[]{1, 0, 2};
        System.out.println(solution(ratings));

        ratings = new int[]{1, 2, 2};
        System.out.println(solution(ratings));

        ratings = new int[]{1, 3, 5, 3, 1, 3, 5, 7, 5, 3, 1, 0};
        System.out.println(solution(ratings));
    }
}
