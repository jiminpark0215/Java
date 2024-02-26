//String클래스의 replace, indexOf, constains 기능을 이용하지 않고 replace 기능 구현

import java.util.Scanner;

public class javaBasicPractice03 {
    public static String solution(char[] str, char[] find, char[] to){
        int idx = 0;
        String replaceStr = "";
        char[] replaceBucket = str.clone();

        do{
            idx = findIndex(replaceBucket, find);

            if (idx != -1){
                for (int i = 0; i < idx; i++) { //담고있는 데이터들을 각 위치에 저장
                    replaceStr += replaceBucket[i];
                }
                for (int i = 0; i < to.length; i++) {
                    replaceStr += to[i];
                }
                for (int i = idx + find.length; i < replaceBucket.length; i++) {
                    replaceStr += replaceBucket[i];
                }
                replaceBucket = replaceStr.toCharArray();
                replaceStr = "";
            }

        }while (idx != -1); //더이상 매칭되는 것이 없을 때 -1 반환

        replaceStr = new String(replaceBucket);

        return replaceStr;
    }

    public static int findIndex(char[] str, char[] find){  //찾고자 하는 문자에 대한 위치용 메서드
        int idx = -1;
        boolean isMatch = false;
        for (int i = 0; i < str.length; i++) { //첫글자가 같은지 비교
            if(str[i] == find[0] && str.length - i >= find.length){ //찾으려는 문자열보다 크거나 같은지
                isMatch = true;
                for (int j = 1; j < find.length; j++) {
                    if (str[i + j] != find[j]){ //한글자라도 맞지 않으면
                        isMatch = false;
                        break;
                    }
                }
            }

            if (isMatch){
                idx = i;
                break;
            }
        }

        return idx;
    }

    public static void main(String[] args){
        String str = "Hello Java, Nice to meet you! Java is fun";
        String find = "Java";
        String to = "자바";

        //기존 replace 사용방식
        System.out.println(str.replace(find, to));

        System.out.println("=====================================");

        char[] strExArr = str.toCharArray();
        char[] findArr = find.toCharArray();
        char[] toArr = to.toCharArray();
        System.out.println(solution(strExArr, findArr, toArr));

        strExArr = "POP".toCharArray();
        findArr = "P".toCharArray();
        toArr = "W".toCharArray();
        System.out.println(solution(strExArr, findArr, toArr));

    }

}
