
import java.util.*;
 
class o6_Bipartite_Graph_BFS_Graph_Coloring {
 
    // A utility function to add an edge in an
    // undirected graph
    static void addEdge(ArrayList<ArrayList<Integer> > adj,
                        int u, int v)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
 
    // A utility function to print the adjacency list
    // representation of graph
    static void
    printGraph(ArrayList<ArrayList<Integer> > adj)
    {
        for (int i = 0; i < adj.size(); i++) {
            System.out.println("\nAdjacency list of vertex"
                               + i);
            System.out.print("head");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(" -> "
                                 + adj.get(i).get(j));
            }
            System.out.println();
        }
    }
 
    static public boolean bfs(int i,int color[],ArrayList<ArrayList<Integer>> adj){
        Queue<Integer> q = new LinkedList<>();
        q.add(i); 
        color[i] = 1; 
        
        while (!q.isEmpty())
        {
            int node = q.poll(); 
            for(Integer it: adj.get(node)) {
                if(color[it] == -1) {
                    color[it] = 1-color[node]; 
                    q.add(it); 
                } 
                else if(color[it]==color[node])return false;
            }
        }
        
        return true; 
    }

    static  public boolean bipartite(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int color[] = new int[V]; 
        Arrays.fill(color,-1);
        for(int i=0;i<V;i++){
            if(color[i]== -1){
           if(!bfs(i,color,adj))return false;
            }
        }
        return true;
        // Code here
    }
    // Driver Code
    public static void main(String[] args)
    {
        // Creating a graph with 5 vertices
        int V = 5;
        ArrayList<ArrayList<Integer> > adj
            = new ArrayList<ArrayList<Integer> >(V);
 
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<Integer>());
 
        // Adding edges one by one
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 4);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);
 
        printGraph(adj);
        
            System.out.println(bipartite(V,adj));
        

    }
}