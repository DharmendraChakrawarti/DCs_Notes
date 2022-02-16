#include<iostream>
#include <bits/stdc++.h>
using namespace std;
//vector<int> adj[9];// 9 is no of vertices
class graph{
public:
int V,E;
vector<int> adj[7];
graph(){
     
     V=5; //no of vertices
     E=7; //no of edges

}

//adjacency_list
void adjectency_list()
{
    for(int i = 0; i < E; i++) {
         int u,v;
    cout<<"Enter the value of Edge-u&v";
cin>>u>>v;
    adj[u].push_back(v);
    adj[v].push_back(u);  //for undirected graph comment it
    }
}

void displaylist()
{
    for (int i = 0; i < V; ++i) {
        cout << "\n Adjacency list of vertex " << i
             << "\n head ";
        for (auto x : adj[i])
            cout << "-> " << x;
        printf("\n");
    }
}

vector<int>bfsOfGraph(){
	    vector<int> bfs; 
	    vector<int> vis(V, 0); 
	    queue<int> q; 
	    q.push(0); 
	    vis[0] = 1; 
	    while(!q.empty()) {
	        int node = q.front();
	        q.pop(); 
	        bfs.push_back(node); 
	        
	        for(auto it : adj[node]) {
	            if(!vis[it]) {
	                q.push(it); 
	                vis[it] = 1; 
	            }
	        }
	    }
	    
	    return bfs; 
	}
};
int main(){
    graph obb;
    //obb.adjacency_metrix();
   // obb.displayMatrix();

   obb.adjectency_list();
   obb.displaylist();
    //displayn searching element
      vector<int>ans=obb.bfsOfGraph();
        for(int i=0;i<ans.size();i++){
        	cout<<ans[i]<<" ";
        }
        
    return 0;
}