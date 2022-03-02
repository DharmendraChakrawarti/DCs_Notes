import java.util.*;

public class o10_cycle_detection_in_directed_graph_using_BFS {
    static void addEdge(ArrayList<ArrayList<Integer> > adj,
                        int u, int v)
    {
        adj.get(u).add(v);
        //adj.get(v).add(u);
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
 
    static public boolean isCyclic(int N, ArrayList<ArrayList<Integer>> adj) {
       // int topo[] = new int[N]; 
        int indegree[] = new int[N]; 
        for(int i = 0;i<N;i++) {
            for(Integer it: adj.get(i)) {
                indegree[it]++; 
            }
        }
        
        Queue<Integer> q = new LinkedList<Integer>(); 
        for(int i = 0;i<N;i++) {
            if(indegree[i] == 0) {
                q.add(i); 
            }
        }
        int cnt = 0;
        while(!q.isEmpty()) {
            Integer node = q.poll(); 
            cnt++; 
            for(Integer it: adj.get(node)) {
                indegree[it]--; 
                if(indegree[it] == 0) {
                    q.add(it); 
                }
            }
        }
        if(cnt == N) return false; 
        return true; 
    }
    // Driver Code
    public static void main(String[] args)
    {
         // Creating a graph with 5 vertices
         int V = 6;
         ArrayList<ArrayList<Integer> > adj
             = new ArrayList<ArrayList<Integer> >(V);
  
         for (int i = 0; i < V; i++)
             adj.add(new ArrayList<Integer>());
  
         // Adding edges one by one
         addEdge(adj, 5, 2);
         addEdge(adj, 5, 0);
         addEdge(adj, 4, 0);
         addEdge(adj, 4, 1);
         addEdge(adj,2, 3);
         //addEdge(adj, 2, 3);
         addEdge(adj, 3, 1);
  
         printGraph(adj);
    
            System.out.println(isCyclic(V,adj));
        

    }
}
