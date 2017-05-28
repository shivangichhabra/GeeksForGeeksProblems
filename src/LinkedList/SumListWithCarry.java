package LinkedList;

/**
 * Created by FS047207 on 5/27/2017.
 */
public class SumListWithCarry {

    static class Node {
        int data;
        Node next;

        Node(int data){
            this.data = data;
        }
    }

    Node head;
    Node sum;
    int carry;

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

    public Node addList(Node a, Node b) {
        int len1 = getLength(a);
        int len2 = getLength(b);

        if(len1 > len2)
            padList(b,len1-len2);
        else
            padList(a, len2-len1);

        SumListWithCarry sum = addListHelper(a,b);
        if(sum.carry > 0) {
            Node result = insertAtFront(sum.sum, sum.carry);
            return result;
        }
        else {
            return sum.sum;
        }
    }


    public int getLength(Node a){
        int len = 0;
        while(a != null){
            len++;
            a = a.next;
        }
        return len;
    }

    public Node insertAtFront(Node list, int data){
        Node n = new Node(data);
        if(list != null)
            n.next = list;
        return n;
    }

    public Node padList(Node list, int len){
        Node head = list;
        for(int i=0; i<len; i++)
            head = insertAtFront(head, 0);
        return head;
    }

    public SumListWithCarry addListHelper(Node a, Node b){
        if(a == null && b == null)
            return new SumListWithCarry();

        SumListWithCarry sum = addListHelper(a.next, b.next);

        int value = sum.carry + a.data+b.data;

        Node x = insertAtFront(sum.sum, value%10);
        sum.sum = x;
        sum.carry = value/10;
        return sum;
    }

    public static void main(String args[]){
        SumListWithCarry list1 = new SumListWithCarry();
        list1.insert(5);
        list1.insert(6);
        list1.insert(3);
        list1.display(list1.head);
        System.out.println(list1.getLength(list1.head));

        SumListWithCarry list2 = new SumListWithCarry();
        list2.insert(8);
        list2.insert(4);
        list2.insert(2);
        list2.display(list2.head);
        System.out.println(list2.getLength(list2.head));

        SumListWithCarry test = new SumListWithCarry();
        Node x = test.addList(list1.head, list2.head);
        test.display(x);
    }


}
