package StringAndArray;

/**
 * Created by FS047207 on 5/23/2017.
 */
public class AllSortedArrays {

    private void getAllSortedArrays(int[] A, int[] B, int[] C, int m, int n, int i, int j, int len, boolean flag) {
        if(flag){
            if(len!=0)
                printArray(C, len+1);

            for(int y=m; y<i; y++) {
                if (len == 0) {
                    C[len] = A[y];
                    getAllSortedArrays(A, B, C, y + 1, n, i, j, len, !flag);
                } else if(A[y] > C[len]){
                    C[len+1] = A[y];
                    getAllSortedArrays(A, B, C, y + 1, n, i, j, len+1, !flag);
                }
            }
        }
        else{
            for(int x = n; x<j; x++) {
                if (B[x] > C[len]) {
                    C[len + 1] = B[x];
                    getAllSortedArrays(A, B, C, m, x + 1, i, j, len + 1, !flag);
                }
            }
        }
    }

    public void generateSortedArrays(int[] A, int[] B, int i, int j){
        int[] C = new int[i+j];

        getAllSortedArrays(A, B, C, 0, 0, i, j, 0, true);
    }

    public void printArray(int[] arr, int n){
        for(int i=0; i<n; i++)
            System.out.print(arr[i] + "  ");
        System.out.println();
    }

    public static void main(String args[]){
        AllSortedArrays a = new AllSortedArrays();
        int A[] = {10, 15, 25};
        int B[] = {5, 20, 30};
        a.generateSortedArrays(A,B, A.length, B.length);
    }
}
