//20240226 Palindrome 연결 리스트
//추가 자료구조 없이 연결 리스트로만 풀어보기. Palindrome이면 true 반환

public class linkedListPractice06 {
    public static boolean checkPalindrome(LinkedList list){
        Node cur = list.head;
        Node left = list.head;
        Node right = null;

        int cnt = 0;
        while (cur != null){
            cnt++;
            right = cur;
            cur = cur.next;
        }

        Node prevRight = right;
        for (int i = 0; i < cnt / 2; i++) { //원소갯수의 절반만 비교
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = left;
            while (right.next != prevRight){
                right = right.next;
            }
        }
        return true;
    }

    public static void main(String[] args){
        LinkedList linkedList = new LinkedList();
        linkedList.addData(1);
        linkedList.addData(3);
        linkedList.addData(5);
        linkedList.addData(3);
        linkedList.addData(1);
        System.out.println(checkPalindrome(linkedList));

        LinkedList linkedList2 = new LinkedList();
        linkedList2.addData(3);
        linkedList2.addData(5);
        linkedList2.addData(5);
        linkedList2.addData(3);
        System.out.println(checkPalindrome(linkedList2));

        LinkedList linkedList3 = new LinkedList();
        linkedList3.addData(1);
        linkedList3.addData(3);
        linkedList3.addData(5);
        linkedList3.addData(1);
        System.out.println(checkPalindrome(linkedList3));


    }
}