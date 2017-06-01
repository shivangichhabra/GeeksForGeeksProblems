package Trees;

/**
 * Created by Shivangi on 5/28/2017.
 */
public class LowestCommonAncestor {

    //In Binary Search Tree
    static class Node{
        int data;
        Node left, right;

        Node(int d){
            data = d;
            left = right = null;
        }
    }

    Node root;

    Node getAncestor(Node root, int i, int j){
        if(root == null)
            return null;

        if(root.data > i && root.data > j)
            return getAncestor(root.left, i, j);

        if(root.data < i && root.data < j)
            return getAncestor(root.right, i, j);

        return root;
    }


    public static void main(String args[]){
        LowestCommonAncestor tree = new LowestCommonAncestor();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);

        Node a = tree.getAncestor(tree.root,10, 14);
        System.out.println(a.data);

        Node b = tree.getAncestor(tree.root,4, 14);
        System.out.println(b.data);
    }
}
