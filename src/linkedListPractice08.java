//20240226 연결리스트 배열 사용 연습
//주어진 문자열 배열을 연결 리스트 배열로 관리하는 코드 작성
//관리 규칙 : 각 문자열의 첫 글자가 같은 것 끼리 같은 연결 리스트로 관리하기

import java.util.HashSet;
import java.util.LinkedList;

class Node8{
    String data;
    Node8 next;

    Node8(){}

    Node8(String data, Node8 next){
        this.data = data;
        this.next = next;
    }
}
class LinkedList8{
    Node8 head;
    char alphabet;

    LinkedList8(){}

    LinkedList8(Node8 node , char alphabet){
        this.head = node;
        this.alphabet = alphabet;
    }

    public boolean isEmpty(){
        return this.head == null;
    }

    public void addData(String data){
        if(this.head == null){
            this.head = new Node8(data, null);
        }else {
            Node8 cur = this.head;
            while (cur.next != null){
                cur = cur.next;
            }
            cur.next = new Node8(data, null);
        }
    }

    public void removeData(String data){
        if(this.isEmpty()){
            System.out.println("List is empty");
            return;
        }

        Node8 cur = this.head;
        Node8 pre = cur;

        while (cur != null){
            if (cur.data.equals(data)){
                if (cur == this.head){
                    this.head = cur.next;
                }else {
                    pre.next = cur.next;
                }
                break;
            }

            pre = cur;
            cur = cur.next;
        }
    }

    public boolean findData(String data){
        if(this.isEmpty()){
            System.out.println("List is empty");
            return false;
        }

        Node8 cur = this.head;

        while (cur != null){
            if (cur.data.equals(data)){
                System.out.println("Data exist!");
                return true;
            }
            cur = cur.next;
        }
        System.out.println("Data not found");
        return false;
    }

    public void showData(){
        if(this.isEmpty()){
            System.out.println("List is empty!");
            return;
        }

        Node8 cur = this.head;
        while (cur != null){
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

}
public class linkedListPractice08 {
    public static void dataCollect(String[] data){
        HashSet<Character> set = new HashSet();
        for (String item : data){
            set.add(item.toCharArray()[0]); //단어의 첫글자를 set애 담음
        }

        System.out.println("Set : " + set);

        Character[] arr = set.toArray(new Character[0]);
        LinkedList8[] linkedList = new LinkedList8[set.size()]; //배열공간 생성
        for (int i = 0; i < linkedList.length; i++) {
            linkedList[i] = new LinkedList8(null, arr[i]); //각각의 위치에 객체 생성
        }

        for (String item : data){
            for (LinkedList8 list : linkedList){
                if (list.alphabet == item.toCharArray()[0]){
                    list.addData(item);
                }
            }
        }

        for (LinkedList8 list : linkedList){
            System.out.print(list.alphabet + " : ");
            list.showData();
        }
    }

    public static void main(String[] args){
        String[] input = {"apple", "watermelon" ,"banana", "apricot", "kiwi", "blueberry", "orange", "cherry"};
        dataCollect(input);

        System.out.println();
        String[] input2 = {"ant", "kangaroo" ,"dog", "cat", "alligator", "duck", "crab", "chicken" , "anaconda", "kitten"};
        dataCollect(input2);

    }
}