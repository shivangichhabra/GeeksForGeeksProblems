package Graph;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Shivangi on 5/28/2017.
 */
public class BridgesINGraph {

    int V;
    LinkedList<Integer> adj[];
    int time = 0;

    BridgesINGraph(int V){
        this.V = V;
        adj = new LinkedList[V];
        for(int i=0; i<V; i++)
            adj[i] = new LinkedList();
    }

    public void addEdge(int v, int u){
        adj[v].add(u);
    }

    public void bridge(){
        boolean[] visited = new boolean[V];
        int[] low = new int[V]; //low[] -> tracks the lowest value in subtree
        int[] disc = new int[V]; // disc[] --> Stores discovery times of visited vertices
        int parent[] = new int[V];

        for(int i=0; i<V; i++)
            parent[i] = -1;

        for(int i=0; i<V; i++)
            if(!visited[i])
                bridge(i, parent, visited, low, disc);
    }

    public void bridge(int u, int[] parent, boolean[] visited, int[] low, int[] disc){

        visited[u] = true;

        disc[u] = low[u] = ++time;

        Iterator<Integer> it = adj[u].iterator();
        while(it.hasNext()){
            int v = it.next();
            if(!visited[v]){
                parent[v] = u;

                bridge(v,parent, visited, low, disc);

                low[u] = Math.min(low[u], low[v]);

                if(low[v] > disc[u])
                    System.out.println(u + "  " + v);

            } else if(v != parent[u]){
                low[u] = Math.min(low[u], low[v]);
            }
        }
    }

    public static void main(String args[]){
        BridgesINGraph graph = new BridgesINGraph(5);
        graph.addEdge(1,0);
        graph.addEdge(0,2);
        graph.addEdge(2,1);
        graph.addEdge(0,3);
        graph.addEdge(3,4);
        graph.bridge();
    }
}
