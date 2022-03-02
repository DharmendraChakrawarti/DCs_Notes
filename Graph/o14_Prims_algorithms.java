import java.util.*;
class pair implements Comparator<pair>
{
    private int v;
    private int weight;
    
    pair(int _v, int _w) { v = _v; weight = _w; }
    
    pair() {}
    
    int getV() { return v; }
    int getWeight() { return weight; }
    
    
    public int compare(pair node1, pair node2) 
    { 
        if (node1.weight < node2.weight) 
            return -1; 
        if (node1.weight > node2.weight) 
            return 1; 
        return 0; 
    } 
}
public class o14_Prims_algorithms {
   
    
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


   public static void spannig_tree(int N,ArrayList<ArrayList<pair> > adj){
    int key[] = new int[N];
    int parent[] = new int[N];    
    boolean mst[]=new boolean[N];
    for(int i = 0;i<N;i++) {
        key[i]=1000000000;
        parent[i]=-1;
        mst[i]=false;
    }
    key[0] = 0; 
    
    PriorityQueue<pair> pq = new PriorityQueue<pair>(N, new pair());
    pq.add(new pair(0, key[0]));
    
    for(int i=0;i<N-1;i++) {
        int node =(int) pq.poll().getV();
        mst[node]=true;
        for(pair it: adj.get(node)) {
            if(mst[it.getV()]==false&&it.getWeight() < key[it.getV()]) {
                parent[it.getV()]=node;;
                key[it.getV()] =  it.getWeight(); 
                pq.add(new pair(it.getV(), key[it.getV()]));
            }
        }
    }

    for (int i = 1; i < N; i++)
    {
        System.out.println( parent[i] + "- "+i);
    }
   }
 
  
    // Driver Code
    public static void main(String[] args)
    {
        int n = 5;
        ArrayList<ArrayList<pair> > adj = new ArrayList<ArrayList<pair> >();
		
		for (int i = 0; i < n; i++) 
			adj.add(new ArrayList<pair>());
			
		adj.get(0).add(new pair(1, 2));
		adj.get(1).add(new pair(0, 2));
		
		adj.get(1).add(new pair(2, 4));
		adj.get(2).add(new pair(1, 4));
		
		adj.get(0).add(new pair(3, 1));
		adj.get(3).add(new pair(0, 1));
		
		adj.get(3).add(new pair(2, 3));
		adj.get(2).add(new pair(3, 3));
		
		adj.get(1).add(new pair(4, 5));
		adj.get(4).add(new pair(1, 5));
		
		adj.get(2).add(new pair(4, 1));
		adj.get(4).add(new pair(2, 1));
        spannig_tree(n,adj);
}
}