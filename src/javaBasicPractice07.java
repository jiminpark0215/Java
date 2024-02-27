//정수형 숫자를 로마 숫자 표기로 변환하는 프로그램

public class javaBasicPractice07 {
    public static String solution(int num){
        String result = "";

        String[] roman = {"M","CM","D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        int i = 0;
        while (num > 0){
            while (num >= values[i]){
                num -= values[i];
                result += roman[i];
            }
            i++;
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(solution(3));
        System.out.println(solution(4));
        System.out.println(solution(6));
        System.out.println(solution(13));
        System.out.println(solution(26));
        System.out.println(solution(1994));

    }

}
