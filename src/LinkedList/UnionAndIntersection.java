package LinkedList;

/**
 * Created by FS047207 on 5/26/2017.
 */
public class UnionAndIntersection {

    static class Node {
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    public void getIntersection(Node a, Node b){
        if(a == null || b == null)
            return;

        Node current = a;

        while(current != null){
            if(isPresent(b, current.data))
                insert(current.data);
            current = current.next;
        }
    }

    public void getUnion(Node a, Node b){
        if(a == null || b == null)
            return;

        //all the elements of first list
        Node first = a;
        while(first != null){
            insert(first.data);
            first = first.next;
        }

        //non common elements of second list
        Node second = b;
        while (second != null){
            //if not present in union list than add
            if(!isPresent(head, second.data)){
                insert(second.data);
            }
            second = second.next;
        }
    }

    boolean isPresent(Node head, int data){
        Node temp = head;
        while(temp != null){
            if(temp.data == data)
                return true;
            temp = temp.next;
        }
        return false;
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

    public void display(){
        Node node = head;
        while(node != null){
            System.out.print(node.data + "  ");
            node = node.next;
        }
        System.out.println("");
    }

    public static void main(String args[]){
        UnionAndIntersection list1 = new UnionAndIntersection();
        list1.insert(20);
        list1.insert(4);
        list1.insert(15);
        list1.insert(10);
        list1.display();

        UnionAndIntersection list2 = new UnionAndIntersection();
        list2.insert(10);
        list2.insert(2);
        list2.insert(4);
        list2.insert(8);
        list2.display();

        UnionAndIntersection intersection = new UnionAndIntersection();
        intersection.getIntersection(list1.head , list2.head);
        intersection.display();

        UnionAndIntersection union = new UnionAndIntersection();
        union.getUnion(list1.head, list2.head);
        union.display();
    }
}
