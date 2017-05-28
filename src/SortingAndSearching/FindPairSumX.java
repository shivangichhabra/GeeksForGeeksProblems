package SortingAndSearching;

/**
 * Created by FS047207 on 5/21/2017.
 */
public class FindPairSumX {

    /*
    O(n^2)
     */
    public int[] findClosestN2(int[] a, int sum){
        int min = Integer.MAX_VALUE;
        int result[] = new int[2];
        for(int i=0; i<a.length; i++){
            for(int j=i+1; j<a.length; j++){
                if(Math.abs(a[i]+a[j]-sum) < min){
                    min = Math.abs(a[i]+a[j]-sum);
                    result[0] = a[i];
                    result[1] = a[j];
                }
            }
        }
        System.out.println(result[0] +"  "+result[1]);
        return result;
    }

    /*
    O(n)
     */
    public int[] findClosestN(int[] a, int sum){
        int[] result = new int[2];
        int diff = Integer.MAX_VALUE;
        int start = 0, end = a.length-1;

        while(start < end) {
            if (Math.abs(a[start] + a[end] - sum) < diff) {
                diff = Math.abs(a[start] + a[end] - sum);
                result[0] = a[start];
                result[1] = a[end];
            }

            if (a[start] + a[end] < sum)
                start++;
            else
                end--;
        }
        System.out.println(result[0] +"  "+result[1]);
        return result;
    }

    public static void main(String args[]){
        FindPairSumX x = new FindPairSumX();
        int arr[] = {10, 22, 28, 29, 30, 40};
        x.findClosestN2(arr, 50);
        x.findClosestN(arr, 50);
    }
}
