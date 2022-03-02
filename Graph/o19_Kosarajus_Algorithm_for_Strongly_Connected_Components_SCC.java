
import java.util.*;
public class o19_Kosarajus_Algorithm_for_Strongly_Connected_Components_SCC {
// A utility function to add an edge in an
    // undirected graph
    static void addEdge(ArrayList<ArrayList<Integer> > adj,
                        int u, int v)
    {
        adj.get(u).add(v);
       // adj.get(v).add(u);
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

          //reverce dfs
          public static void rev_dfs(int node,int vis[],ArrayList<ArrayList<Integer>>sdj){
            vis[node] =1;
            System.out.print(node+" ");
        for(Integer i:sdj.get(node)){
          //`  System.out.println(i+","+perent);
            if(vis[i]==0){
                rev_dfs(i, vis, sdj);
            }
            
        }
              }

   public static void topology_sort(int V,ArrayList<ArrayList<Integer> > adj){
  int  vis[] = new int [V]; 
  Stack<Integer> st=new Stack<Integer>();
    for(int i=0;i<V;i++){
        if(vis[i]==0){
            dfs(i,vis,st,adj);
        }
    }

    ArrayList<ArrayList<Integer> > trancpose
    = new ArrayList<ArrayList<Integer> >(V);

for (int i = 0; i < V; i++)
    trancpose.add(new ArrayList<Integer>()); 
for (int i = 0; i < V; i++){
    vis[i]=0;
    for(int it:adj.get(i)){
trancpose.get(it).add(i);
    }
    
while(!st.isEmpty()){
    int d=st.pop();
    
    System.out.print("SCC: "); 
    rev_dfs(d,vis,trancpose);
				System.out.println(); 
}

}
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
 
        
        
}
}