package Trees;

/**
 * Created by Shivangi on 5/28/2017.
 */
public class MaximumPathSumBT {
    static class Node{
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    Node root;

    private int findMaxSum() {
        int val = Integer.MIN_VALUE;
        return findMaxSum(root, val);
    }


    private int findMaxSum(Node node, int sum){
        if(node == null)
            return 0;

        int l = findMaxSum(node.left, sum);
        int r = findMaxSum(node.right, sum);

        //case node only, node+left , node+right
        int max = Math.max(Math.max(l,r)+node.data, node.data);

        //case node+left+right
        int maxAll = Math.max(max, l+r+node.data);

        sum = Math.max(sum,maxAll);

        return sum;
    }

    public static void main(String args[]){
        MaximumPathSumBT  tree = new MaximumPathSumBT();
        tree.root = new Node(10);
        tree.root.left = new Node(2);
        tree.root.right = new Node(10);
        tree.root.left.left = new Node(20);
        tree.root.left.right = new Node(1);
        tree.root.right.right = new Node(-25);
        tree.root.right.right.left = new Node(3);
        tree.root.right.right.right = new Node(4);

//        tree.root = new Node(1);
//        tree.root.left = new Node(2);
//        tree.root.right = new Node(3);

        System.out.println(tree.findMaxSum());
    }


}
