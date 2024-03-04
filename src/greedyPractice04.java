//20240303 그리디알고리즘
/*
양의 정수 배열 prices가 주어졌다.
각 원소의 의미는 날짜 별 주식 가격을 의미한다.
한 번에 한 주만 보유할 수 있다고 할 때 prices 를 보고 사고 팔기를 반복해서
얻을 수 있는 최대 수익을 반환하는 프로그램을 작성하세요
 */
    public class greedyPractice04 {
        public static int solution(int[] prices){
            if(prices == null || prices.length < 2){
                return 0;
            }

            int proift = 0;
            for (int i = 1; i < prices.length ; i++) {
                if (prices[i] > prices[i - 1]){
                    proift += prices[i] - prices[i - 1];
                }
            }

            return proift;
        }
        
        public static void main(String[] args){
            //Test code
            int[] prices = {5, 1, 6, 4, 3, 5};
            System.out.println(solution(prices));

            prices = new int[]{1, 2, 3, 4, 5};
            System.out.println(solution(prices));

            prices = new int[]{5, 4, 3, 2, 1};
            System.out.println(solution(prices));

        }
    }


