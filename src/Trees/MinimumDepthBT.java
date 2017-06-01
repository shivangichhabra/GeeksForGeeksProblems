package Trees;

/**
 * Created by Shivangi on 5/28/2017.
 */
public class MinimumDepthBT {


    static class Node{
        int data;
        Node left, right;

        Node(int d){
            data = d;
            left = right = null;
        }
    }

    Node root;

    public int getMinDepth(Node root){
        if(root == null)
            return 0;

        if(root.left == null && root.right == null)
            return 1;

        if(root.left == null)
            return getMinDepth(root.right)+1;

        if(root.right == null)
            return getMinDepth(root.left)+1;

        return Math.min(getMinDepth(root.left),getMinDepth(root.right))+1;
    }

    public static void main(String args[]){
        MinimumDepthBT tree = new MinimumDepthBT();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println(tree.getMinDepth(tree.root));
    }
}
