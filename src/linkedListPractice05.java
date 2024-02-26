//단방향 연결 리스트에서 중복 데이터 삭제
class Node5{
    int data;
    Node next;

    Node5(){}
    Node5(int data, Node next){
        this.data = data;
        this.next = next;
    }
}
class LinkedList5{
    Node head;

    LinkedList5(){}
    LinkedList5(Node node){
        this.head = node;
    }
    //연결 리스트 비어있는지 확인
    public boolean isEmpty(){
        if(this.head == null){
            return true;
        }
        return false;
    }

    //연결 리스트으 맨 뒤에 데이터 추가
    public void addData(int data){ //data에 1이 들어오면 노드로 지정.
        if (this.head == null){ //헤드에 노드가 없으면
            this.head = new Node(data, null); //헤드로 지정
        }else {
            Node cur = this.head;
            while (cur.next != null){ //헤드로 부터 노드들을 하나씩 순회하면서 끝까지 도달하고
                cur = cur.next;
            }
            cur.next = new Node(data, null); //맨 끝에 노드를 추가
        }
    }

    //연결 리스트의 맨 뒤의 데이터 삭제
    public void removeData(){
        if(this.isEmpty()){
            System.out.println("List is empty");
            return;
        }

        Node cur = this.head;
        Node prev = cur;

        while (cur.next != null){
            prev = cur;
            cur = cur.next;
        }

        if(cur == this.head){
            this.head = null;
        }else {
            prev.next = null;
        }
    }

    //연결 리스트에서 데이터 찾기
//    public void findData(int data) {
    public boolean findData(int data) {
        if (this.isEmpty()) {
            System.out.println("List is empty");
        }

        Node cur = this.head;
        while (cur != null){
            if(cur.data == data){
                // System.out.println("Data exist!");
                return true;
            }
            cur = cur.next;
        }
        // System.out.println("Data not found!");
        return false;
    }

    //연결 리스트의 모든 데이터 출력
    public void showData() {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        Node cur = this.head;
        while (cur != null){
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}
public class linkedListPractice05 {
    public static LinkedList5 removeDup(LinkedList5 listBefore){
        LinkedList5 listAfter = new LinkedList5();

        Node cur = listBefore.head;
        while (cur != null){
            if(listAfter.findData(cur.data) == false){
                listAfter.addData(cur.data);
            }
            cur = cur.next;
        }

        return listAfter;
    }

    public static void main(String[] args){
        LinkedList5 linkedList = new LinkedList5();
        linkedList.addData(1);
        linkedList.addData(3);
        linkedList.addData(3);
        linkedList.addData(1);
        linkedList.addData(4);
        linkedList.addData(2);
        linkedList.addData(4);
        linkedList.addData(2);
        linkedList.showData();

        linkedList = removeDup(linkedList);
        linkedList.showData();

    }
}