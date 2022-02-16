#include<iostream>
#include <bits/stdc++.h>
using namespace std;
class graph{
public:


//adding elements in list
void adjecency_list(vector<int> adj[],int u,int v){
adj[u].push_back(v);
adj[v].push_back(u);
}


void displaylist(vector<int>adj[],int V)
{
    for (int i = 0; i < V; ++i) {
        cout << "\n Adjacency list of vertex " << i
             << "\n head ";
        for (auto x : adj[i])
            cout << "-> " << x;
        printf("\n");
    }
}

 void dfs(int node, vector<int> &vis, vector<int> adj[], vector<int> &storeDfs) {
        storeDfs.push_back(node); 
        vis[node] = 1; 
        for(auto it : adj[node]) {
            if(!vis[it]) {
                dfs(it, vis, adj, storeDfs); 
            }
        }
    }
public:
	vector<int>dfsOfGraph(int V, vector<int> adj[]){
	    vector<int> storeDfs; 
	    vector<int> vis(V+1, 0); 
      for(int i = 0;i<V;i++) {
        if(!vis[i]) dfs(i, vis, adj, storeDfs); 
      }
	    return storeDfs; 
	}
};

int main(){
    graph d;

    vector<int> adj[5];
    d.adjecency_list(adj, 0, 1);
    d.adjecency_list(adj, 0, 4);
    d.adjecency_list(adj, 1, 2);
    d.adjecency_list(adj, 1, 3);
    d.adjecency_list(adj, 1, 4);
    d.adjecency_list(adj, 2, 3);
    d.adjecency_list(adj, 3, 4);
    d.displaylist(adj,5);
    vector<int> ans=d.dfsOfGraph(5,adj);
   for(int i=0;i<ans.size();i++){
        	cout<<ans[i]<<" ";
        }
    return 0;
}