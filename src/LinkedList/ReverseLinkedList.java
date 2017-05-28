package LinkedList;

/**
 * Created by FS047207 on 5/27/2017.
 */
public class ReverseLinkedList {

    class Node {
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    public void insert(int data){
        Node temp = new Node(data);
        Node current = head;
        if(head == null){
            head = temp;
        }
        else{
            while(current.next != null){
                current = current.next;
            }
            current.next = temp;
        }
    }

    public void reverse(){
        Node before = null;;
        Node current = head;
        Node after = null;
        while (current != null){
            after = current.next;
            current.next = before;
            before = current;
            current = after;
        }
        head = before;
    }

    public void conditionalReverse(int k){
        Node prev = null;;
        Node current = head;
        Node next = null;
        int count = 0;
        while (current != null && count < k){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }
        if(next != null){
            head.next = current;
        }
        head = prev;
    }

    public void display(){
        if(head != null) {
            Node current = head;
            while (current != null) {
                System.out.print(current.data + "  ");
                current = current.next;
            }
            System.out.println("");
        }
    }

    public static void main(String args[]){
        ReverseLinkedList l = new ReverseLinkedList();
        l.insert(1);
        l.insert(2);
        l.insert(3);
        l.insert(4);
        l.insert(5);
        l.insert(6);
        l.insert(7);
        l.insert(8);
        l.insert(9);
        l.insert(10);
        l.display();
        l.reverse();
        l.display();
        l.conditionalReverse(5);
        l.display();
    }
}
