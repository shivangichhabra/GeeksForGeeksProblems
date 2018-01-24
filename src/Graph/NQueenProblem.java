package Graph;

import java.util.Scanner;

public class NQueenProblem {

    //complexity N!
    public static int N;
    public static void main(String args[]){
        NQueenProblem queen = new NQueenProblem();
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        queen.solveNQ();
    }

    public boolean solveNQ(){
        int[][] board = new int[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                board[i][j] = 0;
            }
        }

        return backTrackNQ(board, 0);
    }

    public boolean backTrackNQ(int[][] board, int col){
        if(col >= N) {
            printBoard(board);
            return true;
        }

        for(int i=0; i<N; i++){
            if(isSafe(board, i, col)){
                board[i][col] = 1;

                if(backTrackNQ(board, col+1)) // if condition to print only one solution
                    return true;
                //backTrackNQ(board, col+1); //to print all possible solutions

                board[i][col] = 0; //BACKTRACK
            }
        }

        return false;
    }

    public boolean isSafe(int[][] board, int row, int col){

        /* Check this row on left side */
        for(int i=0; i<col; i++){
            if(board[row][i] == 1)
                return false;
        }

        /* Check upper diagonal on left side */
        for(int i=row, j=col; i>=0 && j>=0; i--, j-- ){
            if(board[i][j] == 1)
                return false;
        }

        /* Check lower diagonal on left side */
        for(int i=row, j=col; i< N && j>=0; i++, j-- ){
            if(board[i][j] == 1)
                return false;
        }

        return true;
    }

    public void printBoard(int[][] board){
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("\n----------------------------\n");
    }
}
