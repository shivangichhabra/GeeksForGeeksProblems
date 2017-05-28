package LinkedList;

/**
 * Created by FS047207 on 5/27/2017.
 */
public class MergerTwoLists {
    static class Node {
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

    //merging lists at alternate positions
    public void mergeLists(Node a, Node b){
        Node temp = a;
        while (a != null && b!= null){
            Node a1 = a.next;
            Node b1 = b.next;

            a.next = b;
            b.next = a1;
            a = a1;
            b = b1;
        }
        head = temp;
    }

    public void display(){
        Node node = head;
        while(node != null){
            System.out.print(node.data + "  ");
            node = node.next;
        }
        System.out.println("");
    }
    public static void main(String args[]){
        MergerTwoLists list1 = new MergerTwoLists();
        list1.insert(3);
        list1.insert(2);
        list1.insert(1);
        list1.display();

        MergerTwoLists list2 = new MergerTwoLists();
        list2.insert(8);
        list2.insert(7);
        list2.insert(6);
        list2.insert(5);
        list2.insert(4);
        list2.display();

        MergerTwoLists merged = new MergerTwoLists();
        merged.mergeLists(list1.head, list2.head);
        merged.display();
    }
}
