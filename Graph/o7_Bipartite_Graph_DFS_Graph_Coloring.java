import java.util.*;;
public class o7_Bipartite_Graph_DFS_Graph_Coloring {
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
    public static boolean dfs(int node,int color[],int co;ArrayList<ArrayList<Integer>>sdj){
        color[node] =co;
    for(Integer i:sdj.get(node)){
        if(color[i]==-1){
            color[i]=1-color[node];
         if(!dfs(i, color,color[i], sdj))return false;
        }
        else if(color[i]==color[node])return false;
    }
    return true;
          }


   public static boolean Bipartite(int V,ArrayList<ArrayList<Integer> > adj){
    int color[] = new int[V]; 
    Arrays.fill(color,-1);
    for(int i=0;i<V;i++){
        if(color[i]==-1){
            if(!dfs(i,color,1,adj))return false;
        }
    }
return true;
   }
 
  
    // Driver Code
    public static void main(String[] args)
    {
        // Creating a graph with 5 vertices
        int V = 4;
        ArrayList<ArrayList<Integer> > adj
            = new ArrayList<ArrayList<Integer> >(V);
 
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<Integer>());
 
        // Adding edges one by one
        // addEdge(adj, 0, 1);
        // addEdge(adj, 0, 4);
        // addEdge(adj, 1, 2);
        // addEdge(adj, 1, 3);
        // addEdge(adj, 1, 4);
        // addEdge(adj, 2, 3);
        // addEdge(adj, 3, 4);
        addEdge(adj, 1, 3);
        addEdge(adj, 2, 0);
        addEdge(adj, 1, 3);
        addEdge(adj, 2, 0);
        
 
        printGraph(adj);
        
            System.out.println(Bipartite(V,adj));
        
    }
}
