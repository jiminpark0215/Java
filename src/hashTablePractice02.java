import java.util.Hashtable;
import java.util.Map;

//20240227
//해시 충돌 해결 - 개방 주소법 ( 선형 탐사법 )
class MyHashTable2 extends MyHashTable{
    MyHashTable2(int size){
        super(size);
    }
    public void setValue(int key , int data){
        int idx = this.getHash(key);
        if (this.elemCnt == this.table.length){
            System.out.println("Hash table is full!");
            return;
        }else if (this.table[idx] == null){ //데이터가 할당되지 않은 상태라면
            this.table[idx] = data;
        }else{
            int newIdx = idx; //충돌 난 지점
            while (true){
                newIdx = (newIdx + 1) % this.table.length; //순차적으로 증가시킴
                if(this.table[newIdx] == null){
                    break;
                }
            }
            this.table[newIdx] = data;//빈 공간을 찾으면서 값을 대입
        }
        elemCnt++;
    }
}

public class hashTablePractice02 {
    public static void main(String[] args){

        MyHashTable2 ht = new MyHashTable2(5);

        ht.setValue(1 , 1);
        ht.setValue(3 , 3);
        ht.printHashTable();

        ht.setValue(1 , 10);
        ht.printHashTable();

        ht.setValue(1 , 20);
        ht.setValue(1 , 30);
        ht.setValue(1 , 40);
        ht.printHashTable();
    }
}
