package Graph;

/**
 * Created by Shivangi on 5/28/2017.
 * Greedy algorithm, minimum spanning tree
 */
public class PrimMinimumSpanningTree {
    static final int V = 9;

    public void dijkstra(int[][] graph, int src){
        int[] parent = new int[V];
        int[] dist = new int[V];
        boolean[] visited = new boolean[V];

        dist[src] = 0;
        parent[0] = -1;
        for(int i=src+1; i<V; i++)
            dist[i] = Integer.MAX_VALUE;

        // Find shortest path for all vertices
        for(int i=0; i<V-1; i++){
            //pick next vertex with min distance
            int u = minDistance(dist, visited);

            visited[u] = true;
            for(int v=0; v<V; v++){
                if(!visited[v] && graph[u][v] != 0 && dist[v] > graph[u][v]){
                    parent[v] = u;
                    dist[v] = graph[u][v];
                }

            }
        }
        printSolution(parent, graph);
    }

    public int minDistance(int[] dist, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < V; i++) {
            if (!visited[i] && dist[i] < min) {
                min = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public void printSolution(int parent[], int[][] graph)
    {
        System.out.println("Egde   Weight");
        for (int i = 1; i < V; i++)
            System.out.println(parent[i] + " - " + i +"       " + graph[i][parent[i]]);
    }

    public static void main(String args[]){
        int graph[][] = {{0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        PrimMinimumSpanningTree p = new PrimMinimumSpanningTree();
        p.dijkstra(graph, 0);

    }
}
