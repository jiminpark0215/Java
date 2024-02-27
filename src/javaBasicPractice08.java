//편집기 구현

import java.util.ArrayList;

public class javaBasicPractice08 {
    public static String solution(String input , String cmd){
        StringBuffer sb = new StringBuffer(input); //문자열이 빈번하게 바뀔 때 유용
        ArrayList<String> cmdArr = new ArrayList<>();//명령어용 배열

        for (String s : cmd.split(" ")){ //공백을 제거해서 배열에 담음
            cmdArr.add(s);
        }

        int curSor = sb.length();
        int cmdIdx = 0;

        while (cmdIdx != cmdArr.size()){
            String cur = cmdArr.get(cmdIdx); //명령어를 하나씩 꺼냄

            if (cur.equals("L")){
                curSor = Math.max(0, curSor - 1); //커서가 0 보다 작지 않도록 처리

            }else if(cur.equals("D")){
                curSor = Math.min(sb.length(), curSor + 1); //커서 오른쪽 이동.

            }else if(cur.equals("B")){
                if (curSor == 0){
                    cmdIdx++;
                    continue;
                }

                sb.delete(curSor - 1, curSor); //좌측의 한 개의 데이터 삭제
                curSor = Math.max(0, curSor - 1);

            } else if (cur.equals("P")) {
                String s = cmdArr.get(++cmdIdx); //데이터를 하나 더 꺼내서 삽입
                sb.insert(curSor, s);
                curSor += 1;

            }
            cmdIdx++;
        }

        return sb.toString();
    }
    public static void main(String[] args){
        System.out.println(solution("aba", "L B"));
        System.out.println(solution("abcd", "P x L P y"));
        System.out.println(solution("abc", "L L L P x L B P y"));
        System.out.println(solution("a", "B B L L D D P a P b P c"));
    }
}
