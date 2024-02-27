//로마 숫자 표기를 정수형으로 변환하는 프로그램

import java.util.HashMap;

public class javaBasicPractice06 {
    public static void solution(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int sum = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length - 1; i++) {
            if (map.get(arr[i]) < map.get(arr[i + 1])){ //작은 기호가 앞에 오는 경우
                sum -= map.get(arr[i]);
            }else {
                sum += map.get(arr[i]);
            }
        }

        sum += map.get(arr[arr.length - 1]);
        System.out.println(sum);

    }

    public static void main(String[] args){
        solution("III");
        solution("IV");
        solution("VI");
        solution("XIII");
        solution("XXVI");
        solution("MCMXCIV");

    }

}
