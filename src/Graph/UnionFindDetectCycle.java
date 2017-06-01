package Graph;

/**
 * Created by Shivangi on 5/28/2017.
 */
public class UnionFindDetectCycle {

    int V, E; //no. of vertices and edges
    Edge edge[];

    class Edge{
        int source, destination; //source and destination of edge;
    }

    UnionFindDetectCycle(int v, int e){
        V = v;
        E = e;
        edge = new Edge[E];
        for(int i=0; i<e; i++)
            edge[i] = new Edge();
    }

    public int find(int[] parent, int i){
        System.out.println(parent[i]);
        if(parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }

    public void union(int[] parent, int i, int j){
            int x = find(parent, i);
            int y = find(parent, j);
            parent[x] = y;
    }

    public boolean isCyclic(UnionFindDetectCycle graph){
        int[] parent = new int[V];

        for(int i=0; i<V; i++)
            parent[i] = -1;

        for(int i=0; i<graph.E; i++){
            int x = find(parent, edge[i].source);
            int y = find(parent, edge[i].destination);
            System.out.println(x + "  " + y);
            if(x==y)
                return true;
            union(parent, x, y);
        }

        return false;
    }

    public static void main(String args[]){
         /*
            0-------------1
             -           -
               -       -
                 -   -
                   2

                   vs

             0-----------1----------2
         */

        int V = 3, E = 3; //E will be 2 in case 2
        UnionFindDetectCycle graph = new UnionFindDetectCycle(V,E);

        //edge 0-1
        graph.edge[0].source = 0;
        graph.edge[0].destination = 1;

        //edge 1-2
        graph.edge[1].source = 1;
        graph.edge[1].destination = 2;

        //edge 2-0 (in second case we will not have this edge)
        graph.edge[2].source = 2;
        graph.edge[2].destination = 0;

        String result = graph.isCyclic(graph) ? "Cycle found!" : "No Cycle";
        System.out.println(result);
    }
}
