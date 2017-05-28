package StringAndArray;

/**
 * Created by FS047207 on 5/23/2017.
 */
public class LengthOfLargestSubarray {

    /*
    O(n^2)
    subarray has contiguous elements if and only if the difference between
    maximum and minimum elements in subarray is equal to the difference
    between last and first indexes of subarray
     */
    public int getLength(int[] arr){
        int maxLen = 1;

        for(int i=0; i<arr.length; i++){
            int min = arr[i], max = arr[i];
            for(int j=i+1; j<arr.length; j++){
                System.out.println(j);
                min = Math.min(min, arr[j]);
                max = Math.max(max, arr[j]);

                if(max - min == j-i) {
                    maxLen = Math.max(maxLen, 1 + max - min);
                }
            }
        }
        return maxLen;
    }

    public static void main(String args[]){
        LengthOfLargestSubarray l = new LengthOfLargestSubarray();
        int[] arr = {10, 12, 11};
        System.out.println(l.getLength(arr));
    }
}
