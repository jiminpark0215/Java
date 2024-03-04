//20240303 그리디알고리즘
/*
양의 정수 n 이 주어지고 다음의 연산을 수행할 수 있을 때,
1. n이 짝수일 경우 2로 나누기 연산
2. n이 홀수일 경우 1을 더하거나 1을 빼는 연산
주어진 n이 1이 되는데 필요한 최소한의 연산 횟수를 반환하세요.
 */
    public class greedyPractice05 {
        public static int solution(int n){
            if (n == 0 || n == 2){
                return 1;
            }

            if (n == 1){
                return 0;
            }

            int cnt = 0;
            while (n != 1){
                if(n == 3){
                    cnt += 2;
                    break;
                }

                if (n % 2 == 0){
                    n /= 2;
                }else if((n + 1) % 4 == 0){
                    n += 1;
                }else if((n - 1) % 4 == 0){
                    n -= 1;
                }
                cnt++;
            }

            return cnt;
        }
        
        public static void main(String[] args){
            //Test code
            System.out.println(solution(8));
            System.out.println(solution(7));
            System.out.println(solution(9));
            System.out.println(solution(6));

        }
    }


