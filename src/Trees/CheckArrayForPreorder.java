package Trees;

import java.util.Stack;

/**
 * Created by Shivangi on 5/28/2017.
 */
public class CheckArrayForPreorder {


    public boolean canRepresentBST(int[] array){
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MIN_VALUE;
        int n = array.length;

        for(int i=0; i<n; i++){
            // If we find a node who is on right side
            // and smaller than root, return false
            if(array[i] < root)
                return false;

            // If pre[i] is in right subtree of stack top,
            // Keep removing items smaller than pre[i]
            // and make the last removed item as new
            // root.
            while(!stack.isEmpty() && stack.peek() < array[i]){
                System.out.println(array[i]);
                root = stack.peek();
                stack.pop();
            }

            // At this point either stack is empty or
            // pre[i] is smaller than root, push pre[i]
            stack.push(array[i]);
        }

        return true;
    }

    public static void main(String args[]) {
        CheckArrayForPreorder t = new CheckArrayForPreorder();

        int[] a = {40, 30, 35, 80, 100};
        System.out.println(t.canRepresentBST(a));

        int[] b = {40, 30, 35, 20, 80, 100};
        System.out.println(t.canRepresentBST(b));

        int[] c = {2, 4, 3, 5};
        System.out.println(t.canRepresentBST(c));

        int[] d = {2, 4, 1};
        System.out.println(t.canRepresentBST(d));
    }
}
