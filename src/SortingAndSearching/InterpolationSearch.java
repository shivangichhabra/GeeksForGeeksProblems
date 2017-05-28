package SortingAndSearching;

/**
 * Created by FS047207 on 5/21/2017.
 */
public class InterpolationSearch {

    /*
    Uniform distribution O(log(log n))
    Worst Case O(n)
    Space O(1)
    Recursive approach
     */
    public int searchR(int[] a, int key, int start, int end){
        if(start > end)
            return -1;

        while(start <= end) {
            int pos = (int) (start + (((double)(end-start)*(key-a[start]))/ (a[end]-a[start])));

            if (a[pos] == key)
                return pos;
            else if (key < a[pos])
                return searchR(a, key, start, pos - 1);
            else
                return searchR(a, key, pos + 1, end);
        }
        return -1;
    }

    /*
   Uniform distribution O(log(log n))
   Worst Case O(n)
   Space O(1)
   Recursive approach
    */
    public int searchI(int[] a, int key){
        int start = 0;
        int end = a.length-1;

        while(start <= end){
            int pos = (int) (start + (((double)(end-start)*(key-a[start]))/ (a[end]-a[start])));

            if(key == a[pos])
                return pos;
            else if(key < a[pos])
                end = pos-1;
            else if (key > a[pos])
                start = pos+1;
        }
        return -1;
    }

    public static void main(String args[]){
        InterpolationSearch is = new InterpolationSearch();
        int[] arr = {10, 12, 13, 16, 18, 19, 20, 21, 22, 23, 24, 33, 35, 42, 47};
        int key = 18;
        System.out.println(is.searchR(arr, key, 0, arr.length-1));
        System.out.println(is.searchI(arr, key));
    }

}
