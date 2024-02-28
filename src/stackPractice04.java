import java.util.Stack;

//20240220 후위 표기법 연산 - 소수로 출력
public class stackPractice04 {
    public static double calculate(String string){
        Stack<Double> stack = new Stack();

        for (String str : string.split(" ")) {
            if (str.equals("+")){
                stack.push(stack.pop() + stack.pop());

            } else if (str.equals("-")) {
                stack.push(- stack.pop() + stack.pop());

            } else if (str.equals("*")) {
                stack.push(stack.pop() * stack.pop());

            } else if (str.equals("/")) {
                stack.push(1 / stack.pop() * stack.pop());

            } else {
                stack.push(Double.parseDouble(str));
            }
        }
        return stack.pop();
    }

    public static void main (String[] args){
        //Test code
        System.out.println(calculate("2 2 +"));
        System.out.println(calculate("2 2 -"));
        System.out.println(calculate("2 2 *"));
        System.out.println(calculate("2 2 /"));

        System.out.println(calculate("1 1 + 2 * 3 * 2 / 5 -"));
        System.out.println(calculate("5 2 * 3 - 8 * 4 /"));

    }
}
