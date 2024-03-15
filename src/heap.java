import java.io.IOException;
import java.util.ArrayList;

//비선형자료구조 힙
//ArrayList로 최소 힙 구현

class MinHeap{
    ArrayList<Integer> heap;

    public MinHeap(){
        this.heap = new ArrayList<>();
        this.heap.add(0);
    }

    public void insert(int data){
        heap.add(data);
        int cur = heap.size() - 1; //insert 하는 곳

        while (cur > 1 && heap.get(cur / 2) > heap.get(cur)){ //비교
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
                targetIdx = heap.get(leftIdx) < heap.get(rightIdx)? leftIdx : rightIdx ;
            }else if (leftIdx < heap.size()){
                targetIdx = cur * 2;
            }else { //자식노드가 없는 상황이면
                break;
            }

            //선정한 값을 부모와 비교
            if (heap.get(cur) < heap.get(targetIdx)){
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
public class heap {
    public static void main(String[] args) throws IOException {
        MinHeap minHeap = new MinHeap();
        System.out.println(" === 데이터 삽입 === ");
        minHeap.insert(30);
        minHeap.insert(40);
        minHeap.insert(10);
        minHeap.printTree();
        minHeap.insert(50);
        minHeap.insert(60);
        minHeap.insert(70);
        minHeap.printTree();
        minHeap.insert(20);
        minHeap.printTree();
        minHeap.insert(30);
        minHeap.printTree();

        System.out.println();
        System.out.println(" === 데이터 삭제 === ");
        System.out.println("삭제 : " + minHeap.delete());
        minHeap.printTree();
        System.out.println("삭제 : " + minHeap.delete());
        minHeap.printTree();
        System.out.println("삭제 : " + minHeap.delete());
        minHeap.printTree();


    }
}