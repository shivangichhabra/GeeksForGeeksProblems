package Trees;

/**
 * Created by Shivangi on 5/28/2017.
 */
public class RemoveNodeForGivenLength {
    static class Node{
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    Node root;

    public Node removePathNode(Node node, int k){
        return removePathNode(node, 0, k);
    }

    public Node removePathNode(Node node, int level , int k){
        if(node == null)
            return null;

        node.left = removePathNode(node.left, level+1, k);
        node.right = removePathNode(node.right, level+1, k);

        if(node.left == null && node.right == null && level <k)
            return null;

        return node;
    }


    public void InOrder(Node node){
        if(node == null)
            return;
        InOrder(node.left);
        System.out.print(node.data+ " ");
        InOrder(node.right);
    }

    public static void main(String args[]){
        RemoveNodeForGivenLength tree = new RemoveNodeForGivenLength();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.left.left = new Node(7);
        tree.root.right.right = new Node(6);
        tree.root.right.right.left = new Node(8);

        tree.InOrder(tree.root);
        System.out.println();

        int k = 4;
        tree.removePathNode(tree.root, k);

        tree.InOrder(tree.root);
    }
}
