package Trees;

/**
 * Created by Shivangi on 5/28/2017.
 */
public class CheckIFSubtreeISBT {


    static class Node{
        char data;
        Node left, right;

        Node(char d){
            data = d;
            left = right = null;
        }
    }


    public boolean isSubtree(Node a, Node b) {
        StringBuilder main = new StringBuilder();
        StringBuilder sub = new StringBuilder();

        buildString(a, main);
        buildString(b, sub);

        //System.out.println(main + "\n" + sub);
        return main.indexOf(sub.toString()) != -1;
    }

    public void buildString(Node n, StringBuilder sb){
        if(n == null) {
            sb.append("X");
            return;
        }
        sb.append(n.data+" ");
        buildString(n.left, sb);
        buildString(n.right, sb);
    }

    public static void main(String args[]){
        CheckIFSubtreeISBT tree = new CheckIFSubtreeISBT();

        Node T = new Node('a');
        T.left = new Node('b');
        T.right = new Node('d');
        T.left.left = new Node('c');
        T.right.right = new Node('e');

        Node S = new Node('a');
        S.left = new Node('b');
        S.right = new Node('d');
        S.left.left = new Node('c');


        Node R = new Node('d');
        R.right = new Node('e');

        System.out.println(tree.isSubtree(T, S));
        System.out.println(tree.isSubtree(T, R));


    }
}
