package LinkedList;

/**
 * Created by FS047207 on 5/26/2017.
 */
public class SortedInsertLinkedList {

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

    public void sortedInsert(int data){
        Node temp = new Node(data);
        Node current = head;
        if(head == null){
            head = temp;
        } else {
            while(current.next != null && current.data < data ){
                current = current.next;
            }
            temp.next = current.next;
            current.next = temp;
        }
    }

    public void display(){
        if(head != null) {
            Node current = head;
            while (current.next != null) {
                System.out.println(current.data + "  ");
                current = current.next;
            }
            System.out.println(current.data);
        }
        else
            System.out.println("List is empty!");
    }

    public static void main(String args[]){
        SortedInsertLinkedList l = new SortedInsertLinkedList();
        l.display();

        l.sortedInsert(1);
        l.sortedInsert(2);
        l.sortedInsert(4);
        l.sortedInsert(5);
        l.sortedInsert(6);
        l.sortedInsert(3);

        l.display();
    }
}
