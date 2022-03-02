import java.util.*;

public class o8_cycle_detection_in_directed_graph_using_DFS {
    // A utility function to add an edge in an
    // undirected graph
    static void addEdge(ArrayList<ArrayList<Integer> > adj,
                        int u, int v)
    {
        adj.get(u).add(v);
       // adj.get(v).add(u);
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
    public static boolean dfs(int node,int vis[],int dfsvis[],ArrayList<ArrayList<Integer>>sdj){
        vis[node] =1;
        dfsvis[node] =1;
    for(Integer i:sdj.get(node)){
      //`  System.out.println(i+","+perent);
        if(vis[i]==0){
            if(dfs(i, vis,dfsvis, sdj))return true;
        }
        else if(dfsvis[i]==1){return true;}
    }
    dfsvis[node] =0;
    return false;
          }


   public static boolean cycl_detection(int V,ArrayList<ArrayList<Integer> > adj){
  int  vis[] = new int [V]; 
  int dfsvis[]=new int [V];
    for(int i=0;i<V;i++){
        if(vis[i]==0){
           if( dfs(i,vis,dfsvis,adj))return true;
        }
    }
return false;
   }
 
  
    // Driver Code
    public static void main(String[] args)
    {
        // Creating a graph with 5 vertices
        // int V = 5;
        int V = 4;
        ArrayList<ArrayList<Integer> > adj
            = new ArrayList<ArrayList<Integer> >(V);
 
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<Integer>());
 
        // Adding edges one by one
        // addEdge(adj, 0,1);
        // addEdge(adj, 0, 4);
        // addEdge(adj, 1, 2);
        // addEdge(adj, 1, 3);   //for false (not cyle)
        // addEdge(adj, 1, 4);
        // addEdge(adj, 2, 3);
        // addEdge(adj, 3, 4); 
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 2);  //for true
        addEdge(adj, 2, 0);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 3);
        
 
        printGraph(adj);
        System.out.println(cycl_detection(V,adj));
    }
}
