package Graph;

/**
 * Created by Shivangi on 5/28/2017.
 */
public class FolydWarshallShortestPath {
    final static int V = 4;
    final static int INF = 999999;


    public void flyodyWarshall(int[][] graph){
        int[][] dist = new int[V][V];

        for(int i=0; i<V; i++)
            for(int j=0; j<V; j++)
                dist[i][j] = graph[i][j];

        for(int k=0; k<V; k++)
            for(int i=0; i<V; i++)
                for(int j=0; j<V; j++)
                    if(dist[i][j] > dist[i][k] +dist[k][j])
                        dist[i][j] = dist[i][k] +dist[k][j];

        print(dist);
    }

    public void print(int[][] graph){
        for(int i=0; i<V; i++){
            for(int j=0; j<V; j++){
                if(graph[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(graph[i][j] + "   ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]){
        int graph[][] = { {0,   5,  INF, 10},
                        {INF, 0,   3, INF},
                        {INF, INF, 0,   1},
                        {INF, INF, INF, 0}
        };
        FolydWarshallShortestPath f = new FolydWarshallShortestPath();
        f.flyodyWarshall(graph);
    }
}
