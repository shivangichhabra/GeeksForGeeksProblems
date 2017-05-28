package StringAndArray;

import java.util.Arrays;

/**
 * Created by FS047207 on 5/23/2017.
 */
public class PythagoreanTriplet {

    /*
    Naive Solution
    O(n^3)
     */
    public void tripletExists(int[] arr){
        for(int i=0; i<arr.length; i++){
            for(int j=i; j<arr.length; j++){
                for(int k = j; k<arr.length; k++){
                    int x = arr[i]*arr[i], y =  arr[j]*arr[j], z =  arr[k]*arr[k];
                    if(x == y+z || y == x+z || z == x+y)
                        System.out.println(arr[i]+"  " + arr[j] + "  " + arr[k]);;
                }
            }
        }
    }


    /*
    O(n^2)
    Using sorting
     */
    public void findTriplet(int[] arr){
        for(int i=0; i<arr.length; i++){
            arr[i] = arr[i]*arr[i];
        }

        Arrays.sort(arr);

        for(int i= arr.length-1; i>=2; i--){
            int start = 0;
            int end = i-1;

            while(start<end){
                if(arr[start]+arr[end] == arr[i]){
                    System.out.println("Found");
                    System.out.println(arr[start] +"  " + arr[end] + "   " + arr[i]);
                }

                if(arr[start]+arr[end] < arr[i])
                    start++;
                else
                    end--;
            }
        }
    }

    public static void main(String args[]){
        PythagoreanTriplet pt = new PythagoreanTriplet();
        int arr[] = {10, 4, 6, 12, 5, 3};
        pt.tripletExists(arr);
        pt.findTriplet(arr);
    }
}
