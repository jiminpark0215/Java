
//연결 리스트를 이용한 이진 트리 구성, 순회

import java.util.LinkedList;
import java.util.Queue;

class Node4{
    char data;
    Node4 left;
    Node4 right;

    public Node4(char data, Node4 left, Node4 right){
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

class BinaryTree2{
    Node4 head;

    BinaryTree2(){}

    BinaryTree2(char[] arr){
        Node4[] nodes = new Node4[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nodes[i] = new Node4(arr[i], null, null);
        }

        for (int i = 0; i < arr.length; i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < arr.length){
                nodes[i].left = nodes[left];
            }
            if (right < arr.length){
                nodes[i].right = nodes[right];
            }
        }
        this.head = nodes[0];
    }

    public void preOrder(Node4 node){
        if (node == null){
            return;
        }

        System.out.println(node.data + " ");
        this.preOrder(node.left);
        this.preOrder(node.right);
    }

    public void inOrder(Node4 node){
        if (node == null){
            return;
        }

        this.preOrder(node.left);
        System.out.println(node.data + " ");
        this.preOrder(node.right);
    }

    public void postOrder(Node4 node){
        if (node == null){
            return;
        }

        this.preOrder(node.left);
        this.preOrder(node.right);
        System.out.println(node.data + " ");
    }

    public void levelOrder(Node4 node){
        Queue<Node4> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()){
            Node4 cur = queue.poll();

            System.out.println(cur.data + "");
            if (cur.left != null){
                queue.offer(cur.left);
            }
            if (cur.right != null){
                queue.offer(cur.right);
            }
        }
    }

}

public class treePractice01 {
    public static void main(String[] args)  {
        //Test code
        char[] arr = new char[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char)('A' + i);
        }

        BinaryTree bt = new BinaryTree(arr);

        System.out.println("=== Preorder ===");
        bt.preOrder(0);
        System.out.println();

        System.out.println("=== Inorder ===");
        bt.inOrder(0);
        System.out.println();

        System.out.println("=== Postorder ===");
        bt.postOrder(0);
        System.out.println();

        System.out.println("=== Levelorder ===");
        bt.levelOrder(0);
        System.out.println();
    }
}