import java.util.*;
class Node{
    private int u,v,weight;
    Node(int _u, int _v, int _w) { u = _u; v = _v; weight = _w; }
    
    Node() {}
    
    int getV() { return v; }
    int getU() { return u; }
    int getWeight() { return weight; }

}
class SortComparator implements Comparator<Node> {
    @Override
    public int compare(Node node1, Node node2) 
    { 
        if (node1.getWeight() < node2.getWeight()) 
            return -1; 
        if (node1.getWeight() > node2.getWeight()) 
            return 1; 
        return 0; 
   

    } 
}

class dc{
//to find parents
 public int find_perents(int i,int perent[]){
    if(perent[i]==i){
        return i;
    }
    return perent[i]=find_perents(perent[i],perent);
}

//to make union
public void union(int a,int b,int renk[],int perent[]){
    int u=find_perents(a,perent);
    int v=find_perents(b,perent);
    if(renk[u]<renk[v]){
        perent[u]=v;
    }
    else if(renk[u]>renk[v]){
        perent[v]=u;
    }
    else{
        perent[u]=v;
        renk[u]++;
    }
    
}

 public void kruskal(int N,ArrayList<Node> adj  ){
  int perent[]=new int[N];
  int renk[]=new int[N];
  Collections.sort(adj,new SortComparator());
  for(int i=0;i<N;i++){
      perent[i]=i;
      renk[i]=0;
  }
  
  int costmat =0;
  ArrayList<Node> list=new ArrayList<Node>();

  for( Node it : adj){
    if(find_perents(it.getU(), perent) != find_perents(it.getV(), perent)) {
        costmat += it.getWeight(); 
        list.add(it); 
        union(it.getU(), it.getV(), perent, renk); 
    }
  }


     System.out.println(costmat);
        for(Node it: list) {
        	System.out.println(it.getU() + " " +it.getV()); 
        }
}}
public class o16_Kruskals_Algorithm {
     
    public static void main(String[] args) {
        
        int n = 5;
        ArrayList<Node> adj = new ArrayList<Node>();
		
			
		adj.add(new Node(0, 1, 2));
		adj.add(new Node(0, 3, 6));
		adj.add(new Node(1, 3, 8));
		adj.add(new Node(1, 2, 3));
		adj.add(new Node(1, 4, 5));
		adj.add(new Node(2, 4, 7));
     dc d=new dc();
     d.kruskal(n,adj);
    }
}
