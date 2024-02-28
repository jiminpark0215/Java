import java.util.Stack;
//20240220 괄호 짝이 맞는지 검사
public class stackPractice03 {

    public static void checkParenthesis(String str){
        Stack stack = new Stack();
        boolean checkFlag = true;

        for (String s : str.split("")){
            if(s.equals("(")){
                stack.push(s);
            }else{
                if(stack.isEmpty()){
                    checkFlag = false;
                    break;
                }else {
                    stack.pop();
                }
            }
        }

        if (checkFlag && stack.isEmpty()){
            System.out.println("PASS!");
        }else {
            System.out.println("FAIL!");
        }
    }

    public static void main (String[] args){
        checkParenthesis("(");
        checkParenthesis(")");
        checkParenthesis("()");
        checkParenthesis("()()()");
        checkParenthesis("(())()");
        checkParenthesis("(((()))");
    }
}
