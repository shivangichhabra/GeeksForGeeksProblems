package StringAndArray;

import java.util.Arrays;

/**
 * Created by FS047207 on 5/23/2017.
 */
public class CountTriplets {

    /*
    O(n^3)
     */
    public void getCount(int[] arr, int sum){
        int count = 0;
        for(int i=0; i<arr.length-2; i++){
            for(int j=i+1; j<arr.length-1; j++){
                for(int k=j+1; k<arr.length; k++){
                    if(arr[i] + arr[j] + arr[k] < sum)
                        count++;
                }
            }
        }
        System.out.println(count);
    }

    /*
    O(n^2)
     */
    public void getCountFaster(int[] a, int sum){
        int count = 0;
        Arrays.sort(a);

        for(int i=0; i<a.length-2; i++){
            int j = i+1;
            int k = a.length-1;
            while(j<k){
                if(a[i] + a[j] + a[k] >= sum)
                    k--;
                else {
                    count += k - j;
                    j++;
                }
            }
        }
        System.out.println(count);
    }

    public static void main(String args[]){
        CountTriplets ct = new CountTriplets();
        int[] a = {5, 1, 3, 4, 7};
        int sum = 12;
        ct.getCount(a, sum);
        ct.getCountFaster(a, sum);
    }
}
