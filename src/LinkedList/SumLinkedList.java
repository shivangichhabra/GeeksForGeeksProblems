package LinkedList;

/**
 * Created by FS047207 on 5/27/2017.
 */
public class SumLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data){
            this.data = data;
        }
    }

    Node head;

    /*
    Input:
        First List: 7->5->9->4->6  // represents number 64957
        Second List: 8->4 //  represents number 48
    Output
        Resultant list: 5->0->0->5->6  // represents number 65005
    */
    public Node addList(Node a, Node b, int carry){
        Node result = new Node(0);
        Node temp = result;
        int value = carry;
        while(a!=null || b!= null) {
            if (a != null)
                value += a.data;

            if (b != null)
                value += b.data;

            result.data = value % 10;

            if (a != null || b != null) {
                Node next = addList(a != null ? a.next : null,
                        b != null ? b.next : null,
                        value >= 10 ? 1 : 0);
                result.next = next;
            }
        }
        return result;
    }

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

    public void display(Node node){
        while(node != null){
            System.out.print(node.data + "  ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]){
        SumLinkedList list1 = new SumLinkedList();
        list1.insert(7);
        list1.insert(5);
        list1.insert(9);
        list1.insert(4);
        list1.insert(6);
        list1.display(list1.head);

        SumLinkedList list2 = new SumLinkedList();
        list2.insert(8);
        list2.insert(4);
        list2.display(list2.head);

        SumLinkedList test = new SumLinkedList();
        Node x = test.addList(list1.head, list2.head, 0);
        test.display(x);
    }
}
