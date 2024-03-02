//20240223 데크 변형
// 중간에 데이터 추가하는 기능을 구현. 단 , 추가적인 자료구조는 생성하지 말고 구현

class MyDeque3{
    int[] arr;
    int front = 0;
    int rear = 0;

    MyDeque3(int size){
        this.arr = new int[size + 1];
    }

    public boolean isEmpty(){
        return this.rear == this.front;
    }

    public boolean isFull(){
        return (this.rear + 1) % this.arr.length == this.front;
    }
    public void addFirst(int data){
        if (this.isFull()){
            System.out.println("Deque is full!");
            return;
        }
        this.arr[this.front] = data;
        this.front = (this.front - 1 + this.arr.length) % this.arr.length;
    }

    public void addLast(int data){
        if (this.isFull()){
            System.out.println("Deque is full!");
            return;
        }
        this.rear = (this.rear + 1) % this.arr.length;
        this.arr[this.rear] = data;
    }

    public void addMiddle(int data){
        if (this.isFull()){
            System.out.println("Deque is full!");
            return;
        }

        int elements = this.rear - this.front;//원소가 얼마나 들어있는지 세보기
        if(elements < 0){ //음수일 떄
            elements = this.arr.length + elements;
        }

        int mid = (this.rear - elements / 2 + this.arr.length) % this.arr.length + 1; //중간지점 찾기

        int start = (this.rear + 1) % this.arr.length;
        int end = (this.rear - elements / 2 + this.arr.length) % this.arr.length;

        for (int i = start; i != end ; i = (i - 1 + this.arr.length) % this.arr.length) {
            this.arr[i] = this.arr[(i - 1 + this.arr.length) % this.arr.length];
        }
        this.arr[mid] = data;
        this.rear = (this.rear + 1) % this.arr.length;

    }

    public Integer removeFirst(){
        if(this.isEmpty()){
            System.out.println("Deque is empty!");
            return null;
        }
        this.front = (this.front + 1) % this.arr.length;
        return this.arr[this.front];
    }

    public Integer removeLast(){
        if (this.isEmpty()){
            System.out.println("Deque is empty!");
            return null;
        }
        int data = this.arr[this.rear];
        this.rear = (this.rear - 1 + this.arr.length) % this.arr.length;
        return data;
    }

    public void printDeque(){
        int start = (this.front + 1) % this.arr.length;
        int end = (this.rear + 1) % this.arr.length;

        for (int i = start; i != end ; i = (i + 1) % this.arr.length ) {
            System.out.print(this.arr[i] + " ");
        }
        System.out.println();
    }
}
public class dequePractice05 {
    public static void main(String[] args){
        //Test code
        MyDeque3 myDeque1 = new MyDeque3(5);
        myDeque1.addLast(1);
        myDeque1.addLast(2);
        myDeque1.addLast(3);
        myDeque1.addLast(4);
        myDeque1.printDeque();

        myDeque1.addMiddle(10);
        myDeque1.printDeque();

        MyDeque3 myDeque2 = new MyDeque3(5);
        myDeque2.addLast(10);
        myDeque2.addLast(10);
        myDeque2.addLast(10);
        myDeque2.addLast(10);
        myDeque2.addLast(10);
        myDeque2.removeFirst();
        myDeque2.removeFirst();
        myDeque2.removeFirst();
        myDeque2.removeFirst();
        myDeque2.addLast(11);
        myDeque2.addLast(12);
        myDeque2.addLast(13);
        myDeque2.printDeque();

        myDeque2.addMiddle(100);
        myDeque2.printDeque();

    }
}
