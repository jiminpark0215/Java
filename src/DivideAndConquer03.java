/*2차원 정수형 배열 lists가 주어졌다.
 lists[i] 에는 각 링크드 리스트의 원소 정보가 들어있고,
 원소들은 오름차순 정렬된 상태이다.
 모든 링크드 리스트를 하나의 정렬된 링크드 리스트로 합병하세요.
 */

class Node7{
    int val;
    Node7 next;

    Node7(int val){
        this.val = val;
        this.next = null;
    }
}
public class DivideAndConquer03 {
    public static Node7 solution(Node7[] lists){
        if (lists == null || lists.length == 0){
            return null;
        }

        return divideList(lists, 0, lists.length - 1);
    }

    public static Node7 divideList(Node7[] lists, int left, int right){
        if (left == right){
            return lists[left];
        }

        int mid = left + (right - left) / 2;
        Node7 l1 = divideList(lists, left, mid);
        Node7 l2 = divideList(lists, mid + 1, right);

        return mergeLiset( l1, l2);
    }

    //돌면서 합치는 구간
    public static Node7 mergeLiset(Node7 l1, Node7 l2){
        if (l1 == null){
            return l2;
        }

        if (l2 == null){
            return l1;
        }

        Node7 merge = new Node7(0);
        Node7 cur = merge;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
            }

            cur = cur.next;
        }

        if (l1 != null){
            cur.next = l1;
        }

        if (l2 != null){
            cur.next = l2;
        }

        return merge.next;

    }


    //문제에 주어진 2차원 배열을 링크드 리스트로 구성
    public static void setUpLinkedList(Node7[] node, int[][] lists){
        for (int i = 0; i < lists.length; i++) {
            node[i] = new Node7(lists[i][0]); //헤드
        }

        for (int i = 0; i < lists.length; i++) {
            Node7 cur = node[i];
            for (int j = 1; j < lists[i].length; j++) {
                cur.next = new Node7(lists[i][j]);
                cur = cur.next;
            }
        }
    }

    //결과 출력 부분
    public static void printList(Node7 node){
        Node7 cur = node;
        while (cur.next != null){
            System.out.print(cur.val + " -> ");
            cur = cur.next;
        }
        System.out.println(cur.val);
    }

    public static void main(String[] args){
        int[][] lists = {{2, 3, 9}, {1, 5, 7}, {3, 6, 7, 11}};
        Node7[] node = new Node7[lists.length];
        setUpLinkedList(node, lists);
        Node7 combinedNode = solution(node);
        printList(combinedNode);


    }
}
