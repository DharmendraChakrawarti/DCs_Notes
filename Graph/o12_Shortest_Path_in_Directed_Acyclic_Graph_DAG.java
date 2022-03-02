
import java.util.*; 
class Pair
{
    private int v;
    private int weight;
    Pair(int _v, int _w) { v = _v; weight = _w; }
    int getV() { return v; }
    int getWeight() { return weight; }
}
public class o12_Shortest_Path_in_Directed_Acyclic_Graph_DAG {
    
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
    public static void dfs(int node,int vis[],Stack<Integer> st,ArrayList<ArrayList<Pair>>sdj){
        vis[node] =1;
        
    for(Pair i:sdj.get(node)){
      //`  System.out.println(i+","+perent);
        if(vis[i.getV()]==0){
            dfs(i.getV(), vis,st, sdj);
        }
        
    }
    st.push(node); 
          }


   public static void topology_sort(int V,ArrayList<ArrayList<Pair> > adj){
  int  vis[] = new int [V]; 
  Stack<Integer> st=new Stack<Integer>();
    for(int i=0;i<V;i++){
        if(vis[i]==0){
            dfs(i,vis,st,adj);
        }
    }
    int dist[] = new int[V];
    for(int i=0;i<V;i++)dist[i]=Integer.MAX_VALUE;

     dist[0]=0;
    while(st.empty()==false){
        int node =(int)st.pop();
        if(dist[node]!=Integer.MAX_VALUE){
            for(Pair it: adj.get(node)) {
                if(dist[node] + it.getWeight() < dist[it.getV()]) {
                    dist[it.getV()] = dist[node] + it.getWeight(); 
                }

        }
    }



   }
   for (int i = 0; i < V; i++)
        {
            if (dist[i] == Integer.MAX_VALUE)
                System.out.print( "INF ");
            else
                System.out.print( dist[i] + " ");
        }
}
  
    // Driver Code
    public static void main(String[] args)
    { 
       
        // Adding edges one by one
        int n = 6;
        ArrayList<ArrayList<Pair> > adj = new ArrayList<ArrayList<Pair> >();
		
		for (int i = 0; i < n; i++) 
			adj.add(new ArrayList<Pair>());
			
		adj.get(0).add(new Pair(1, 2));
		adj.get(0).add(new Pair(4, 1));
		adj.get(1).add(new Pair(2, 3));
		adj.get(2).add(new Pair(3, 6));
		adj.get(4).add(new Pair(2, 2));
		adj.get(4).add(new Pair(5, 4));
		adj.get(5).add(new Pair(3, 1));
        topology_sort(n,adj);
}
}

