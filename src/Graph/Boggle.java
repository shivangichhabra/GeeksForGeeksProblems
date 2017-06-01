package Graph;

/**
 * Created by Shivangi on 5/28/2017.
 */
public class Boggle {

    private int N;
    private int M;
    private char[][] board;
    private boolean[][] visited;
    String dictionary[] = {"GEEKS", "FOR", "QUIZ", "GO", "CAT"}; //list of words

    Boggle(char[][] board){
        this.N = board.length;
        this.M = board[0].length;
        visited = new boolean[N][M];
        this.board = board;
    }

    public void showWords(){
        for(int i=0; i<N; i++)
            for(int j=0; j<M; j++)
                dfs("", i,j);
    }

    private void dfs(String prefix, int i, int j){
        if(i<0 || i>=N || j<0 || j>= M) return;

        if(visited[i][j]) return;

        visited[i][j] = true;

        prefix +=board[i][j];

        if(isWord(prefix))
            System.out.println(prefix);

        //go through all neightbors
        for(int x=i-1; x<=i+1; x++)
            for(int y=j-1; y<=j+1; y++)
                dfs(prefix, x, y);

        visited[i][j] = false;
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                s = s + board[i][j] + " ";
            }
            s = s + "\n";
        }
        return s;
    }


    public boolean isWord(String str){
        for(int i=0; i<dictionary.length; i++)
            if(dictionary[i].equals(str))
                return true;
        return false;
    }

    public static void main(String args[]){
        char board[][] = {{'G', 'I', 'Z', 'C'},
                          {'U', 'E', 'K', 'A'},
                          {'Q', 'S', 'E', 'T'}};
        Boggle b = new Boggle(board);
        b.showWords();
    }
}
