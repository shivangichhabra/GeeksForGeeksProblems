package LinkedList;

/**
 * Created by FS047207 on 5/26/2017.
 */
public class DetectAndRemoveLoop {

    static class Node {
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    public void detectAndRemoveLoop(Node head){
        if(head == null)
            return;

        Node slow = head;
        Node fast = head.next; //.next;

        while(fast != null && fast.next != null){
            if(slow == fast) {
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast == null || fast.next == null) {
            System.out.println("No loops");
            return;
        }

        slow = head;
        while (slow != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }
        System.out.println(fast.data+ "  " + slow.data);
        fast.next = null;
    }

    public void display(Node node){
        while (node != null){
            System.out.print(node.data + "  " );
            node =  node.next;
        }
        System.out.println();
    }

    public static void main(String args[]){
        DetectAndRemoveLoop l = new DetectAndRemoveLoop();

        Node head = new Node(50);
        head.next = new Node(20);
        head.next.next = new Node(15);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(10);

        l.display(head);
        l.detectAndRemoveLoop(head);
        head.next.next.next.next.next = head.next.next;
        System.out.println("after breaking loop");
        l.detectAndRemoveLoop(head);
        l.display(head);
    }
}
