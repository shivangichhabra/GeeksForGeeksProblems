package LinkedList;

import java.util.Random;

/**
 * Created by FS047207 on 5/26/2017.
 */
public class SelectRandomNode {

    static class Node {
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    Random random = new Random();

    public int findAndPrintRandNum(Node head){
        if(head == null)
            return 0;

        Node temp = head;
        for(int i=1; temp.next != null; i++){

            temp = temp.next;
            if((int)(Math.random()*i+1) == i) //new Random().nextInt(i+1) == i or new Random.nextInt(i) == 0 or Math.random()%i == 0
                 return temp.data;

        }
        return 0;
    }

    public static void main(String args[]){
        SelectRandomNode l = new SelectRandomNode();
        Node head = new Node(5);
        head.next = new Node(20);
        head.next.next = new Node(4);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(10);
        head.next.next.next.next.next = new Node(23);
        head.next.next.next.next.next.next = new Node(30);
        head.next.next.next.next.next.next.next = new Node(90);
        head.next.next.next.next.next.next.next.next = new Node(46);

        System.out.println(l.findAndPrintRandNum(head));
    }
}
