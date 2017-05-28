package StringAndArray;

/**
 * Created by FS047207 on 5/23/2017.
 */
public class SmallestPositiveInteger {

    public int getSmallestInt(int[] a){
        int min = 1;

        for(int i=0; i<a.length ; i++){
            if(a[i] <= min){
                min = min+a[i];
            }
        }

        return min;
    }

    public static void main(String args[]){
        SmallestPositiveInteger sp = new SmallestPositiveInteger();
        int arr[] = {1, 2, 3, 4, 5, 6};
        System.out.println(sp.getSmallestInt(arr));
    }
}
