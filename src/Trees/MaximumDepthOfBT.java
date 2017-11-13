package Trees;

/**
 * Created by FS047207 on 11/12/2017.
 */
public class MaximumDepthOfBT {

    class Node{
        int data;
        Node left;
        Node right;
    }
    public int maxDepth(Node root){
        if(root == null)
            return 0;

        return 1+Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
