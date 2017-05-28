package StringAndArray;

/**
 * Created by FS047207 on 5/22/2017.
 */
public class ZigZag {


    public String zigzagString(String s, int numRows){
        char c[] = s.toCharArray();
        StringBuilder sb[] = new StringBuilder[numRows];
        for(int i=0; i<sb.length; i++)
            sb[i] = new StringBuilder();

        int len = s.length()-1;
        int x = 0;
        while(x<len){
            for(int i=0; i<numRows && x<len ; i++){
                sb[i].append(c[x++]);
            }

            for(int j=numRows-2; j>0 && x<len; j--){
                sb[j].append(c[x++]);
            }
        }

        for(int i=1; i<sb.length; i++)
            sb[0].append(sb[i]);

        return sb[0].toString();
    }

    /*
    converted array should be in form a < b > c < d > e < f.
    O(n)
    */
    public void zigzagArray(int[] array, int n){
        boolean flag = true;

        for(int i=0; i<n-1;i++){
            if(flag){
                if(array[i] > array[i+1]){
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1]= temp;
                }
            } else {
                if(array[i] < array[i+1]){
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1]= temp;
                }
            }
            flag = !flag;
        }
    }

    public static void main(String args[]){
        ZigZag z = new ZigZag();
        System.out.println(z.zigzagString("HOWAREYOUTODAY", 3));
        int a[] = {4, 3, 7, 8, 6, 2, 1};
        z.zigzagArray(a, a.length-1);

        for(int i=0; i<a.length; i++)
            System.out.print(a[i] + "  ");
    }
}
