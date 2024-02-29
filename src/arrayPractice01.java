import java.util.ArrayList;
import java.util.Arrays;

//20240221
class MyArray {
    int[] arr;

    //배열 초기 사이즈 설정
    MyArray(int size) {
        this.arr = new int[size];
    }

    //배열에 데이터 삽입
    public void insertData(int index, int data) {
        if (index < 0 || index > this.arr.length) { // 비정상적인 범위의 데이터가 들어올 시 에러처리
            System.out.println("Index Error!");
            return;
        }
        int[] arrDup = this.arr.clone();
        this.arr = new int[this.arr.length + 1];

        for (int i = 0; i < index; i++) { //추가하려는 인덱스의 위치까지는 할당
            this.arr[i] = arrDup[i];
        }

        for (int i = index + 1; i < this.arr.length; i++) { //추가하려는 인덱스의 위치 다음부터 끝까지 할당
            this.arr[i] = arrDup[i - 1];
        }

        this.arr[index] = data;
    }

    //배열에서 특정 데이터 삭제
    public void removeData(int data) {
        int targetIndex = -1;
        for (int i = 0; i < this.arr.length; i++) {
            targetIndex = i;
            break;
        }

        if (targetIndex == -1) {
            System.out.println("해당 데이터가 없습니다..");
        } else {
            int[] arrDup = this.arr.clone(); //찾는 데이터가 있으면 삭제
            this.arr = new int[this.arr.length - 1];

            for (int i = 0; i < targetIndex; i++) {
                this.arr[i] = arrDup[i];
            }

            for (int i = targetIndex; i < this.arr.length; i++) {
                this.arr[i] = arrDup[i + 1];
            }


        }
    }
}
    public class arrayPractice01 {
        public static void main(String[] args){
            //Test code
            int size = 5;
            MyArray myArray = new MyArray(size);

            for (int i = 0; i < size; i++) {
                myArray.arr[i] = i + 1;
            }
            System.out.println(Arrays.toString(myArray.arr));

            myArray.arr[0] = 10;
            System.out.println(Arrays.toString(myArray.arr));

            myArray.insertData(2,20);
            System.out.println(Arrays.toString(myArray.arr));

            myArray.insertData(6,60);
            System.out.println(Arrays.toString(myArray.arr));

            myArray.insertData(-1,0);

            myArray.removeData(4);
            System.out.println(Arrays.toString(myArray.arr));

            myArray.removeData(5);
            System.out.println(Arrays.toString(myArray.arr));

        }
    }


