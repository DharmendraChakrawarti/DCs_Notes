
import java.util.*;

 
class o3_DFS_adjecency_list  {
 
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
    public static void dfs(int node,boolean vis[],ArrayList<Integer> storDfs,ArrayList<ArrayList<Integer>>sdj){
        storDfs.add(node);
        vis[node] =true;
    for(Integer i:sdj.get(node)){
        if(vis[i]==false){
            dfs(i, vis, storDfs, sdj);
        }
    }
          }


   public static ArrayList<Integer>dfsOfGraph(int V,ArrayList<ArrayList<Integer> > adj){
    ArrayList <Integer>storDfs = new ArrayList<Integer>();
    boolean vis[] = new boolean[V]; 
    for(int i=0;i<V;i++){
        if(vis[i]==false){
            dfs(i,vis,storDfs,adj);
        }
    }
return storDfs;
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
        ArrayList<Integer> ans=dfsOfGraph(V,adj);
        for (int i=0;i<ans.size();i++){
            System.out.println(ans.get(i));
        }
    }
}