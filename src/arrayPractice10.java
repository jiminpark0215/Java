import sun.security.mscapi.CKeyPairGenerator;

import java.util.*;

//20240223
/*
문자열배열 strs가 주어졌을 때 anagram 으로 묶어서 출력하는 프로그램을 작성.
anagram 은 절차 순서를 바꾸면 같아지는 문자를 의미.
예) elvis <-> lives
정렬시 값이 같으면 anagram
 */
public class arrayPractice10 {
    public static ArrayList<ArrayList<String>> soulution(String[] strs) {
        if (strs == null || strs.length == 0){
            return new ArrayList<>();
        }

        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String s : strs){
            char[] cArr = s.toCharArray();
            sort(cArr);
            String key = String.valueOf(cArr);

            if (!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(s); //정렬된 값을 map에 담음
        }

        return new ArrayList<>(map.values());
    }

    public static void sort(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0 ; j--) {
                if (arr[j] < arr[j-1]){
                    char tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args){
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(soulution(strs));

        strs = new String[]{"abc", "bac", "bca", "xyz", "zyx", "aaa"} ;
        System.out.println(soulution(strs));

    }
}

