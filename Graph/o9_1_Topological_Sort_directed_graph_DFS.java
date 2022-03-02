import java.util.*;

public class o9_1_Topological_Sort_directed_graph_DFS {
    
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
    public static void dfs(int node,int vis[],Stack<Integer> st,ArrayList<ArrayList<Integer>>sdj){
        vis[node] =1;
        
    for(Integer i:sdj.get(node)){
      //`  System.out.println(i+","+perent);
        if(vis[i]==0){
            dfs(i, vis,st, sdj);
        }
        
    }
    st.push(node); 
          }


   public static int[] topology_sort(int V,ArrayList<ArrayList<Integer> > adj){
  int  vis[] = new int [V]; 
  Stack<Integer> st=new Stack<Integer>();
    for(int i=0;i<V;i++){
        if(vis[i]==0){
            dfs(i,vis,st,adj);
        }
    }
    int arr[]=new int[V];
    int ind=0;
while(!st.isEmpty()){
    arr[ind++]=st.pop();
}
return arr;

   }
 
  
    // Driver Code
    public static void main(String[] args)
    {
        // Creating a graph with 5 vertices
        int V = 6;
        // int V = 4;
        ArrayList<ArrayList<Integer> > adj
            = new ArrayList<ArrayList<Integer> >(V);
 
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<Integer>());
 
        // Adding edges one by one
        addEdge(adj,5, 2);
        addEdge(adj,5, 0);
        addEdge(adj,4, 0);
        addEdge(adj,4, 1);
        addEdge(adj,2, 3);
        addEdge(adj,3, 1);
 
        printGraph(adj);
        int []arr=topology_sort(V,adj);
        for (int i=0;i<arr.length;i++){System.out.println(arr[i]);}
}
}