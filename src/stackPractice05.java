import java.util.Stack;

//20240220 두 문자열 비교
// - 단 #은 백스페이스로 바로 이전의 문자를 삭제한다고 가정
public class stackPractice05 {
    public static boolean stringCompare(String s1, String s2){
        String s1After = doBackSpace(s1);
        String s2After = doBackSpace(s2);

        return s1After.equals(s2After);
    }

    public static String doBackSpace(String s){
        Stack stack = new Stack();
        for (char c : s.toCharArray()) {
            if(c == '#' && !stack.isEmpty()){
                stack.pop();
            }else {
                stack.push(c);
            }
        }
        return String.valueOf(stack);
    }

    public static void main (String[] args){
        //Test code
        String s1 = "tree";
        String s2 = "th#ree";
        System.out.println(stringCompare(s1, s2));

        s1 = "ab#a";
        s2 = "aab#";
        System.out.println(stringCompare(s1, s2));

        s1 = "wo#w";
        s2 = "ww#o";
        System.out.println(stringCompare(s1, s2));

    }
}
