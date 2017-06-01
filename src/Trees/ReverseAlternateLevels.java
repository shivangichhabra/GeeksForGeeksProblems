package Trees;

/**
 * Created by Shivangi on 5/28/2017.
 */
public class ReverseAlternateLevels {
    static class Node{
        char data;
        Node left, right;

        Node(char data){
            this.data = data;
            left = right = null;
        }
    }

    Node root;


    public void reverse(Node root){
        if(root != null)
            preOrder(root.left, root.right, 0);
    }

    public void preOrder(Node root1, Node root2, int level){
        if(root1 == null || root2 == null)
            return;

        if(level%2 == 0) {
            char temp = root1.data;
            root1.data = root2.data;
            root2.data = temp;
        }

        preOrder(root1.left, root2.right, level+1);
        preOrder(root1.right, root2.left, level+1);
    }

    public void InOrder(Node root) {
        if (root == null)
            return;
        InOrder(root.left);
        System.out.print(root.data + "  ");
        InOrder(root.right);
    }

    public static void main(String args[]){
        ReverseAlternateLevels tree = new ReverseAlternateLevels();
        tree.root = new Node('a');
        tree.root.left = new Node('b');
        tree.root.right = new Node('c');
        tree.root.left.left = new Node('d');
        tree.root.left.right = new Node('e');
        tree.root.right.left = new Node('f');
        tree.root.right.right = new Node('g');
        tree.root.left.left.left = new Node('h');
        tree.root.left.left.right = new Node('i');
        tree.root.left.right.left = new Node('j');
        tree.root.left.right.right = new Node('k');
        tree.root.right.left.left = new Node('l');
        tree.root.right.left.right = new Node('m');
        tree.root.right.right.left = new Node('n');
        tree.root.right.right.right = new Node('o');

        tree.InOrder(tree.root);
        System.out.println();

        tree.reverse(tree.root);
        tree.InOrder(tree.root);
    }
}
