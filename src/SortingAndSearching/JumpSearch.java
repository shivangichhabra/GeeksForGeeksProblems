package SortingAndSearching;

/**
 * Created by FS047207 on 5/22/2017.
 */
public class JumpSearch {

    public int search(int[] a, int key){
        int n = a.length;
        int step = (int) Math.floor(Math.sqrt(n));

        int prev = 0;
        while(a[Math.min(step, n)-1] < key){
             prev = step;
             step *= 2;
            if(prev > n)
                return -1;
        }

        while (a[prev] < key){
            prev++;
            if(prev == Math.min(step,n))
                return -1;
        }

        if(a[prev] == key)
            return prev;

        return -1;
    }

    public static void main(String args[]){
        JumpSearch js = new JumpSearch();
        int arr[] = { 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610};
        int x = 13;
        System.out.println(js.search(arr, x));
    }
}
