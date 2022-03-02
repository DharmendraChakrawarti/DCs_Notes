 import java.util.*;
class o15_Disjoint_Set_Union_By_Rank_and_Path_Compression{
    static public int[]renk=new int[100000];
    static public int[]perent=new int[100000];
    
    //for make a set
    static public void make_set(int i){
     renk[i]=0;
     perent[i]=i;
    }

    //to find parents
    static public int find_perents(int i){
        if(perent[i]==i){
            return i;
        }
        return perent[i]=find_perents(perent[i]);
    }

    //to make union
    static public void union(int a,int b){
        int u=find_perents(a);
        int v=find_perents(b);
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
    public static void main(String[] args) {
        try{
        int m;
        Scanner sc = new Scanner(System.in);
        m=sc.nextInt();
        while(m-->0){
            
            int u=sc.nextInt();
            int v=sc.nextInt();
            union(u,v);
        }
       sc.close();
        //find parent are same or not
        if(find_perents(3)==find_perents(4)){
            System.out.println("same");
        }
        else
        System.out.println("not sme");
    }catch(Exception e){
        System.out.println(e);
    }
    }
}