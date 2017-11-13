package StringAndArray;

import SortingAndSearching.InterpolationSearch;

/**
 * Created by FS047207 on 11/12/2017.
 */
public class ReverseInteger {

    public int reverse(int input){
        if(input == 0)
            return 0;

        long output = 0;
        while(input != 0){
            output  = output*10 + input%10;
            input = input/10;
        }

        if(output > Integer.MAX_VALUE || output < Integer.MIN_VALUE)
            return 0;

        return (int)output;
    }

    public static void main(String args[]){
        ReverseInteger r = new ReverseInteger();
        System.out.println(r.reverse(-1234567891));

    }
}
