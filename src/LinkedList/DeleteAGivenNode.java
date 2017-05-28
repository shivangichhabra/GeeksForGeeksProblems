package LinkedList;

/**
 * Created by FS047207 on 5/27/2017.
 */
public class DeleteAGivenNode {

    static class Node {
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    public void deleteNode(Node start, Node tobedeleted){
        if(start == tobedeleted){
            if(start.next == null)
               return;

            start.data = start.next.data;
            start.next = start.next.next;
        }
        else {
            Node current = start;
            while (current.next != null && current.next != tobedeleted){
                current = current.next;
            }
            current.next = tobedeleted.next;
        }
    }

    public void display(Node node){
        while (node != null) {
            System.out.print(node.data + "  ");
            node = node.next;
        }
        System.out.println();
    }
    public static void main(String args[]){
        DeleteAGivenNode l = new DeleteAGivenNode();

        Node head = new Node(12);
        head.next = new Node(15);
        head.next.next = new Node(10);
        head.next.next.next = new Node(11);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next.next = new Node(3);

        l.display(head);

        l.deleteNode(head, head.next.next);

        l.display(head);

        l.deleteNode(head,head);

        l.display(head);


    }
}
