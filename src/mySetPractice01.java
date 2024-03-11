import java.util.ArrayList;

//기초수학 - 집합
//ArrayList를 사용한 집합 구현 실습 ( 집합 관련 연산 사용 X )
class MySet01{
    //ArrayList
    ArrayList<Integer> list;

    // 생성자 1
    MySet01() {
        this.list = new ArrayList<Integer>();
    }

    // 생성자 2
    MySet01(int[] arr){
        this.list = new ArrayList<Integer>();
        for (int item : arr){
            this.list.add(item);
        }
    }

    // 원소 추가 (중복 X)
    public void add(int x){
        for (int item : this.list){ //리스트와 원소 비교
            if (item == x){
                return;
            }
        }
        this.list.add(x);
    }

    // 교집합
    public MySet01 retainAll(MySet01 b){
        MySet01 result = new MySet01();
        for (int itemA : this.list){ //자기 자신을 순회하면서
            for (int itemB : b.list){ //새로 들어온 집합
                if (itemA == itemB){
                    result.add(itemA);
                }
            }
        }
        return result;
    }

    // 합집합
    public MySet01 addAll(MySet01 b){
        MySet01 result = new MySet01();
        for (int itemA : this.list) { //자기 자신을 순회하면서
            result.add(itemA);
        }

        for (int itemB : b.list){ //새로 들어온 집합
            result.add(itemB);
        }

        return result;

    }

    // 차집합
    public MySet01 removeAll(MySet01 b){
        MySet01 result = new MySet01();
        for (int itemA : this.list){
            boolean containFlag = false;

            for (int itemB : b.list){
                if (itemA == itemB){
                    containFlag = true;
                    break;
                }
            }

            if (!containFlag){ //false
                result.add(itemA);
            }

        }
        return result;
    }

}
public class mySetPractice01 {
    public static void main(String[] args) {
        //Test code
        MySet01 a = new MySet01();

        a.add(1);
        a.add(1);
        a.add(1);
        System.out.println(a.list);

        a.add(2);
        a.add(3);
        System.out.println(a.list);

        a = new MySet01(new int[]{1, 2, 3, 4, 5});
        MySet01 b = new MySet01(new int[]{2, 4, 6, 8, 10});
        System.out.println("a : " + a.list);
        System.out.println("b : " + b.list);

        MySet01 result = a.retainAll(b);
        System.out.println("교집합 : " + result.list);

        result = a.addAll(b);
        System.out.println("합집합 : " + result.list);

        result = a.removeAll(b);
        System.out.println("차집합 : " + result.list);


    }
}