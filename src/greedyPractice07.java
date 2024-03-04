//20240303 그리디알고리즘
/*
정수 num 이 주어졌을 때,
num 숫자에서 두 자리를 최대 한 번만 교체하여 얻을 수 있는 최대값을 출력하세요.
 */
    public class greedyPractice07 {
        public static int solution(int num){
            char[] cArr = String.valueOf(num).toCharArray();
            int[] maxArr = new int[cArr.length];

            int max = 0;
            for (int i = cArr.length - 1; i >= 0 ; i--) {
                max = Math.max(max, cArr[i] - '0');
                maxArr[i] = max;
            }
            for (int i = 0; i < cArr.length - 1; i++) {
                if (cArr[i] - '0' < maxArr[i + 1]){
                    for (int j = cArr.length - 1; j >= i + 1; j--) {
                        if (cArr[j] - '0' == maxArr[i + 1]){
                            char tmp = cArr[j];
                            cArr[j] = cArr[i];
                            cArr[i] = tmp;
                            return Integer.parseInt(String.valueOf(cArr));
                        }
                    }
                }
            }

            return num;
        }
        
        public static void main(String[] args){
            //Test code
            System.out.println(solution(2736));
            System.out.println(solution(7116));
            System.out.println(solution(91));

        }
    }


