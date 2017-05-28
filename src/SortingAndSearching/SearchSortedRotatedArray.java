package SortingAndSearching;

/**
 * Created by FS047207 on 5/21/2017.
 */
public class SearchSortedRotatedArray {

    /*
    O(n)
    Solution 1
     */
    public int searchN(int[] a, int key){
        for(int i=0; i<a.length; i++){
            if(a[i] == key)
                return i;
        }
        return -1;
    }

    /*
    O(log n)
    Solution 2 (Recursion)
    */
    public int searchLogN1(int[] a, int start, int end, int key) {
        if (start > end)
            return -1;

        int mid = (start + end) / 2;
        if (a[mid] == key)
            return mid;

        if (a[start] <= a[mid]) {
            if (key >= a[start] && key < a[mid])
                return searchLogN1(a, start, mid - 1, key);
            else
                return searchLogN1(a, mid + 1, end, key);
        } else {
            if (key > a[mid] && key <= a[end])
                return searchLogN1(a, mid + 1, end, key);
            else
                return searchLogN1(a, start, mid - 1, key);
        }
    }
    /*
    O(log n)
    Solution 3 Iterative approach
     */
    public int searchLogN2(int[] a, int key){
        int start = 0;
        int end = a.length-1;
        while(start <= end){
            int mid = (start+end)/2;
            if(a[mid] == key)
                return mid;

            if(a[start] < a[mid]){
                if(key < a[mid] && key >= a[start])
                    end = mid-1;
                else
                    start = mid+1;
            } else {
                if(key > a[mid] && key <= a[end])
                    start = mid+1;
                else
                    end = mid-1;
            }
        }
        return -1;
    }


    /*
   O(log n)
   Solution 4 (Using pivot and binary search

    */
    public int searchLogN3(int[] a, int key){
        int pivot = findPivot(a, 0, a.length-1);

        if(pivot == -1)
            return binarySearch(a, 0, a.length-1, key);

        if(a[pivot] == key)
            return pivot;
        if(a[0] <= key)
            return binarySearch(a, 0, pivot-1, key);
        return binarySearch(a, pivot+1, a.length-1, key);
    }

    public int binarySearch(int[] a, int start, int end, int key){
        if(start > end)
            return -1;

        int mid = (start+end)/2;
        if(a[mid] == key)
            return mid;
        else if (a[mid] < key)
            return binarySearch(a, mid+1, end, key);
        else
            return binarySearch(a, start, mid-1, key);
    }

    public int findPivot(int[] a, int start, int end){
        if(start > end)
            return -1;

        if(start == end) return start;

        int mid = (start+end)/2;
        if(mid < end && a[mid] > a[mid+1])
            return mid;
        if(mid > start && a[mid] < a[mid-1])
            return mid-1;
        if(a[start] >= a[end])
            return findPivot(a, start, mid-1);
        return findPivot(a, mid+1, end);
    }

    public static void main(String args[]){
        SearchSortedRotatedArray s = new SearchSortedRotatedArray();
        int[] a = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        System.out.println(s.searchN(a,3));
        System.out.println(s.searchLogN1(a,0, a.length-1, 3));
        System.out.println(s.searchLogN2(a, 3));
        System.out.println(s.searchLogN3(a, 3));
    }
}
