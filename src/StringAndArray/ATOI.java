package StringAndArray;

/**
 * Created by FS047207 on 11/12/2017.
 */
public class ATOI {
    //case to consider
    //can be positive or negative
    //can overflow
    //can have space
    //can start with no digit
    //stop traversing when space is enountered

    public int atoi(String s) {
        if(s.length() == 0 || s == null)
            return 0;

        long num = 0;
        int sign = 1;
        int i = 0;

        s = s.trim();
        if (s.charAt(0) == '+'){
            i++;
        }

        if(s.charAt(0) == '-'){
            sign = -1;
            i++;
        }

        while(i<s.length() && s.charAt(i) != ' '){

            if(!Character.isDigit(s.charAt(i)))
                return (int)num*sign;

            num = num*10 + s.charAt(i)-'0';

            if(num*sign > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if(num*sign < Integer.MIN_VALUE) return Integer.MIN_VALUE;

            i++;
        }
        return (int)num*sign;
    }

    public static void main(String args[]){
        ATOI a = new ATOI();
        System.out.println(a.atoi("100 100"));
    }

}
