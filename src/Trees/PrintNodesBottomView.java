package Trees;

import java.util.*;

/**
 * Created by Shivangi on 5/28/2017.
 */
public class PrintNodesBottomView {
    static class Node{
        int data;
        int hd;
        Node left, right;

        Node(int data){
            this.data = data;
            left = right = null;
            this.hd = Integer.MAX_VALUE;
        }
    }

    Node root;

    public void bottomView(){
        if(root == null)
            return;

        int hd = 0;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Node> queue = new LinkedList<>();

        root.hd = hd;
        queue.add(root);

        while(!queue.isEmpty()){
            Node temp = queue.remove();

            hd = temp.hd;
            //last node at that horizontal distance will stay in map
            map.put(hd, temp.data);
            if(temp.left != null){
                temp.left.hd = hd-1;
                queue.add(temp.left);
            }

            if(temp.right != null){
                temp.right.hd = hd+1;
                queue.add(temp.right);
            }
        }


        for(int m : map.values()){
            System.out.print(m + "  ");
        }
    }

    public static void main(String args[]){

        PrintNodesBottomView tree = new PrintNodesBottomView();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(5);
        tree.root.left.right = new Node(3);
        tree.root.right.left = new Node(4);
        tree.root.right.right = new Node(25);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);

        tree.bottomView();

    }
}
