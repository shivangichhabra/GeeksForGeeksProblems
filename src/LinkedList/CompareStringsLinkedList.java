package LinkedList;

/**
 * Created by FS047207 on 5/26/2017.
 */
public class CompareStringsLinkedList {

    static class Node {
        char data;
        Node next;

        Node(char data){
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    /*
    0  : Both the strings are same
    1  : first string lexicographically greater
    -1 : second string lexicographically  greater
     */
    public int compare(Node a, Node b){
        if(a == null || b == null)
            return 0;

        while(a != null && b != null && a.data == b.data){
            a = a.next;
            b = b.next;
        }

        if(a != null && b != null){
            return a.data > b.data ? 1 : -1;
        }

        if(a != null && b == null)
            return 1;

        if(a == null && b != null)
            return -1;

        return 0;
    }

    public static void main(String args[]){
        CompareStringsLinkedList list = new CompareStringsLinkedList();

        Node a = new Node('g');
        a.next = new Node('e');
        a.next.next = new Node('e');
        a.next.next.next = new Node('k');
        a.next.next.next.next = new Node('s');
        a.next.next.next.next.next = new Node('a');

        Node b = new Node('g');
        b.next = new Node('e');
        b.next.next = new Node('e');
        b.next.next.next = new Node('k');
        b.next.next.next.next = new Node('s');
        b.next.next.next.next.next = new Node('b');

        System.out.println(list.compare(a,b));
    }
}
