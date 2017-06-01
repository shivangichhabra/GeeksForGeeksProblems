package Trees;

/**
 * Created by Shivangi on 5/28/2017.
 */
public class CheckIfCompleteBT {

    static class Node{
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    Node root;

    public boolean isCompleteBT(Node root){
        if(root == null)
            return true;

        if(root.left == null && root.right == null)
            return true;

        if(root.left != null && root.right != null)
            return isCompleteBT(root.left) && isCompleteBT(root.right);
        return false;
    }

    public static void main(String args[]){
        CheckIfCompleteBT tree = new CheckIfCompleteBT();
        tree.root = new Node(10);
        tree.root.left = new Node(20);
        tree.root.right = new Node(30);
        tree.root.left.right = new Node(40);
        tree.root.left.left = new Node(50);
        tree.root.right.left = new Node(60);
        tree.root.left.left.left = new Node(80);
        tree.root.right.right = new Node(70);
        tree.root.left.left.right = new Node(90);
        tree.root.left.right.left = new Node(80);
        tree.root.left.right.right = new Node(90);
        tree.root.right.left.left = new Node(80);
        tree.root.right.left.right = new Node(90);
        tree.root.right.right.left = new Node(80);
        tree.root.right.right.right = new Node(90);

        System.out.println(tree.isCompleteBT(tree.root));
    }
}
