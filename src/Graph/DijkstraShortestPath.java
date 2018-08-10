package Graph;

/**
 * Created by Shivangi on 5/28/2017.
 *  Greedy Algorithm for Shortest path
 */
public class DijkstraShortestPath {

    static final int V = 9;

    public void dijkstra(int[][] graph, int src){
        int[] dist = new int[V];
        boolean[] visited = new boolean[V];
        int[] parent = new int[V];

        parent[0] = -1;
        dist[src] = 0;

        for(int i=src+1; i<V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        // Find shortest path for all vertices
        for(int i=0; i<V-1; i++){
            //pick next vertex with min distance
            int u = minDistance(dist, visited);

            visited[u] = true;
            for(int v=0; v<V; v++){
                if(!visited[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE  && (dist[u] + graph[u][v]) < dist[v]) {
                    parent[v] = u;
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }
        printSolution(dist, parent);
    }

    public int minDistance(int[] dist, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < V; i++) {
            if (!visited[i] && dist[i] <= min) {
                min = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public void printSolution(int dist[], int[] parent)
    {
        System.out.println("Vertex \t\tDistance \t\tPath");
        int src = 0;
        for (int i = 1; i < V; i++) {
            System.out.print(src+ "->" +i + " \t\t " + (dist[i] > 9 ? dist[i] : dist[i]+" ") + " \t\t\t " + src + " ");
            printPath(parent, i);
            System.out.println();
        }
    }

    public void printPath(int[] parent, int i){
        if(parent[i] == -1)
            return;

        printPath(parent, parent[i]);
        System.out.print(i + " ");
    }

    public static void main(String args[]){
        int graph[][] = {{0, 4, 0, 0, 0, 0, 0, 8, 0},
                        {4, 0, 8, 0, 0, 0, 0, 11, 0},
                        {0, 8, 0, 7, 0, 4, 0, 0, 12},
                        {0, 0, 7, 0, 9, 14, 0, 0, 0},
                        {0, 0, 0, 9, 0, 10, 0, 0, 0},
                        {0, 0, 4, 0, 10, 0, 2, 0, 0},
                        {0, 0, 0, 14, 0, 2, 0, 1, 6},
                        {8, 11, 0, 0, 0, 0, 1, 0, 7},
                        {0, 0, 2, 0, 0, 0, 16, 7, 0}
        };
        DijkstraShortestPath p = new DijkstraShortestPath();
        p.dijkstra(graph, 0);
    }
}
