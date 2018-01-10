package StringAndArray;

import java.util.Stack;

/**
 * Created by FS047207 on 5/22/2017.
 */
public class ReverseStringWthSpecialChars {

    /*
    O(n)
    But space could be the issue
     */
    public String reverseWithSpace(String s){
        char chars[] = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<chars.length; i++){
            if ((chars[i] >= 97 && chars[i] <= 122) || (chars[i] >= 65 && chars[i] <= 90))
                stack.push(s.charAt(i));
        }

        int x = 0;
        for(int i=0; i<chars.length; i++) {
            if ((chars[i] >= 97 && chars[i] <= 122) || (chars[i] >= 65 && chars[i] <= 90)) {
                chars[x++] = stack.pop();
            }
            else{
                chars[x++] = chars[i];
            }
        }

        return String.valueOf(chars);
    }

    /*
    O(n)
    No extra space
     */
    public String reverseWithoutSpace(String s){
        char c[] = s.toCharArray();
        int start = 0;
        int end = s.length()-1;

        while (start <= end){
            if( !isChar(c[start]) )
                start++;
            else if( !isChar(c[end]) )
                end--;
            else {
                swap(c, start, end);
                start++;
                end--;
            }
        }
        return String.valueOf(c);
    }

    public void swap(char[] c, int i, int j){
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }

    public boolean isChar(char c){
        if((c >= 97 && c <= 122) || (c >= 65 && c <= 90))
            return true;
        return false;
    }

    public static void main(String args[]){
        ReverseStringWthSpecialChars rs = new ReverseStringWthSpecialChars();
        System.out.println(rs.reverseWithSpace("Ab,c,de!$"));
        System.out.println(rs.reverseWithoutSpace("Ab,c,de!$"));
    }
}
