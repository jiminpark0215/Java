import java.io.IOException;
import java.util.ArrayList;

//비선형자료구조 힙
//ArrayList로 최대 힙 구현

class MaxHeap{
    ArrayList<Integer> heap;

    public MaxHeap(){
        this.heap = new ArrayList<>();
        this.heap.add(0);
    }

    public void insert(int data){
        heap.add(data);
        int cur = heap.size() - 1; //insert 하는 곳

        while (cur > 1 && heap.get(cur / 2) < heap.get(cur)){ //비교 수정
            int parentVal = heap.get(cur / 2);
            heap.set(cur / 2, data);//스왑
            heap.set(cur, parentVal);

            cur /= 2;

        }
    }
    public Integer delete(){
        if (heap.size() == 1){
            System.out.println("Heap is empty!");
            return null;
        }

        int target = heap.get(1);

        heap.set(1, heap.get(heap.size() - 1)); //마지막 데이터 세팅
        heap.remove(heap.size() - 1 );

        int cur = 1; // 최상위 노드
        while (true){
            int leftIdx = cur * 2;
            int rightIdx = cur * 2 + 1;
            int targetIdx = -1;

            if (rightIdx < heap.size()){ 
                //자식노드들 중에 큰 값을 선택
                targetIdx = heap.get(leftIdx) > heap.get(rightIdx)? leftIdx : rightIdx ;
            }else if (leftIdx < heap.size()){
                targetIdx = cur * 2;
            }else { //자식노드가 없는 상황이면
                break;
            }

            //선정한 값을 부모와 비교. 새로 넣은 값이 노드값보다 더 크면 수정
            if (heap.get(cur) > heap.get(targetIdx)){
                break;
            }else{
                int parentVal = heap.get(cur);
                heap.set(cur, heap.get(targetIdx));
                heap.set(targetIdx, parentVal);
                cur = targetIdx;
            }
        }

        return target;
    }

    public void printTree(){
        for (int i = 1; i < this.heap.size(); i++) { //0은 더미데이터
            System.out.print(this.heap.get(i) + " ");
        }
        System.out.println();
    }
}
public class heap2 {
    public static void main(String[] args) throws IOException {
        MaxHeap maxHeap = new MaxHeap();
        System.out.println(" === 데이터 삽입 === ");
        maxHeap.insert(30);
        maxHeap.insert(40);
        maxHeap.insert(10);
        maxHeap.printTree();
        maxHeap.insert(50);
        maxHeap.insert(60);
        maxHeap.insert(70);
        maxHeap.printTree();
        maxHeap.insert(20);
        maxHeap.printTree();
        maxHeap.insert(30);
        maxHeap.printTree();

        System.out.println();
        System.out.println(" === 데이터 삭제 === ");
        System.out.println("삭제 : " + maxHeap.delete());
        maxHeap.printTree();
        System.out.println("삭제 : " + maxHeap.delete());
        maxHeap.printTree();
        System.out.println("삭제 : " + maxHeap.delete());
        maxHeap.printTree();


    }
}