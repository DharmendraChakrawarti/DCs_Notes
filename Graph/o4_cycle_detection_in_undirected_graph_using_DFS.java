
import java.util.*;

 
class o4_cycle_detection_in_undirected_graph_using_DFS{
 
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


    //for DFS
    public static boolean dfs(int node,boolean vis[],ArrayList<ArrayList<Integer>>sdj,int perent){
        vis[node] =true;
    for(Integer i:sdj.get(node)){
      //`  System.out.println(i+","+perent);
        if(vis[i]==false){
            if(dfs(i, vis, sdj,node))return true;
        }
        else if(i!=perent){return true;}
    }
    return false;
          }


   public static boolean cycl_detection(int V,ArrayList<ArrayList<Integer> > adj){
    boolean vis[] = new boolean[V]; 
    for(int i=0;i<V;i++){
        if(vis[i]==false){
           if( dfs(i,vis,adj,-1))return true;
        }
    }
return false;
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
        System.out.println(cycl_detection(V,adj));
    }
}