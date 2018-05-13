package SortingAndSearching;

import java.util.Arrays;

/**
 * Created by FS047207 on 5/21/2017.
 */
public class FindKth {

    /*
    O(nlog(n))
    Sort and return k-1th
     */
    public int SmallestKNLogN(int[] a, int k){
        Arrays.sort(a);
        return a[k-1];
    }


    /*
    O(n)
    Using quick Sort
    worst case could be o(n^2)
     */
    public int SmallestKN(int[] a, int k){
        if(k < 0 || a == null)
            return -1;

        return getKth(a, a.length-k+1, 0, a.length-1);
    }

    public int getKth(int[] a, int k , int start, int end){
        if(start > end)
            return -1;

        int pivot = a[end];
        int l = start, r = end;
        while(true){
            if(l < r && a[l] < pivot){
                l++;
            }

            if(r > l && a[r] > pivot){
                r--;
            }

            if(l == r){
              break;
            }
            swap(a, l, r);
        }

        swap(a, l, end);
        if(k == l)
            return pivot;
        else if(k > l) //right side
            return getKth(a, k, l+1, end);
        else //left side
            return getKth(a, k, start, l-1);

    }

    public void swap(int []a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static void main(String args[]){
        FindKth k = new FindKth();
        int arr[] = {7, 10, 4, 3, 20, 15};
        System.out.println(k.SmallestKNLogN(arr, 4));
        System.out.println(k.SmallestKN(arr, 4));
    }
}
