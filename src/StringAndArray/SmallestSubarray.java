package StringAndArray;

/**
 * Created by FS047207 on 5/23/2017.
 */
public class SmallestSubarray {

    /*
    O(n^2)
     */
    public int getSubArrayLength(int[] a, int sum){
        int minlen = a.length+1;

        for(int i=0; i<a.length; i++){
            int sumSoFar = a[i];
            if(sumSoFar > sum)
                return 1;

            for(int j=i+1; j<a.length; j++){
                sumSoFar += a[j];

                if(sumSoFar > sum && (j-i+1) < minlen)
                    minlen = j-i+1;
            }
        }
        return minlen;
    }


    /*
    O(n)
     */
    public int getArrayLength(int[] a, int sum){
        int end = 0;
        int start = 0;
        int sumSoFar = 0;
        int n = a.length;
        int minLen = a.length+1;

        while(end < n){
             while(sumSoFar <= sum && end < n)
                 sumSoFar += a[end++];

             while(sumSoFar > sum && start < n){
                 if(end-start < minLen)
                     minLen = end-start;

                 sumSoFar -= a[start++];
             }
        }
        return minLen;
    }
    public static void main(String args[]){
        SmallestSubarray ss = new SmallestSubarray();
        int[] arr = {1, 4, 45, 6, 0, 19};
        int sum = 51;
        System.out.println(ss.getSubArrayLength(arr, sum));
        System.out.println(ss.getArrayLength(arr, sum));
    }
}
