import java.util.Arrays;
import java.util.HashSet;

//20240225
/*
문자열 s를 역순으로 출력하는 프로그램을 작성하세요
단, 각 단어의 알파벳 순서는 그대로 출력.
문장에 공백이 여러개일 시 , 단어와 단어 사이 하나의 공백을 제외한 나머지 공백은 제거
 */
public class twoPointerPractice03 {
    public static String solution(String s){
        if(s == null ) {
            return null;
        }
        if(s.length() < 2){
            return s;
        }

        s = removeSpaces(s);
        char[] cArr = s.toCharArray();
        reverseString(cArr, 0, s.length() - 1); // 모든걸 다 뒤집고
        reverseWords(cArr, s.length()); //단어만 다시 뒤집어줌
        return new String(cArr);

    }

   public static String removeSpaces(String s){
        int p1 = 0;
        int p2 = 0;

        char[] cArr = s.toCharArray();
        int length = s.length();

        while (p2 < length){
            while (p2 < length && cArr[p2] == ' '){
                p2++;
            }

            while (p2 < length && cArr[p2] != ' '){
                cArr[p1++] = cArr[p2++];
            }

            while (p2 < length && cArr[p2] == ' '){
                p2++;
            }

            if (p2 < length){
                cArr[p1++] = ' ';
            }

        }
        return new String(cArr).substring(0, p1); //다시 문자열로 반환
    }

   public static void reverseString(char[] cArr, int i, int j){
        while (i < j){
            char tmp = cArr[i];
            cArr[i++] = cArr[j];
            cArr[j--] = tmp;
        }
    }

   public static void reverseWords(char[] cArr, int length){
        int p1 = 0;
        int p2 = 0;

        while (p1 < length){
            while (p1 < p2 || p1 < length && cArr[p1] == ' '){
                p1++;
            }
            while (p2 < p1 || p2 < length && cArr[p2] != ' '){
                p2++;
            }
            reverseString(cArr, p1, p2 -1);
        }
    }

    public static void main(String[] args) {
        //Test code
        System.out.println(solution("the sky is blue"));
        System.out.println(solution("  hello      java    "));

    }
}
