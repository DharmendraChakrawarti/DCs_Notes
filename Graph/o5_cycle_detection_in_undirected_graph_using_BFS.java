import java.util.*;
class node{
    int first;
    int second;
    public node(int first,int second ){
        this.first = first;
        this.second = second;
}
}
class o5_cycle_detection_in_undirected_graph_using_BFS{
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
 
    static  public boolean cycle_bfs(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean vis[] = new boolean[V]; 
        Arrays.fill(vis,false);
        for(int i=0;i<V;i++){
            if(vis[i]== false)
           if( bfs(i,vis,adj))return true;
        }
        return false;
        // Code here
    }



    static public boolean bfs(int i,boolean vis[],ArrayList<ArrayList<Integer>> adj){
        Queue<node> q = new LinkedList<>();
        q.add(new node(i,-1)); 
        vis[i] = true; 
        
        while (!q.isEmpty())
        {
            int node = q.peek().first; 
            int per = q.peek().second;
            q.remove(); 
 
    
            for(Integer it: adj.get(node)) {
                if(vis[it] == false) {
                    vis[it] = true; 
                    q.add(new node(it,node)); 
                } 
                else if(per!=it)return true;
            }
        }
        
        return false; 
    }
    // Driver Code
    public static void main(String[] args) {
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
       
             
            System.out.println(cycle_bfs(V, adj));
         
 
     }
}
