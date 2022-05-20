class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<connections.size();i++){
            int u = connections.get(i).get(0);
            int v = connections.get(i).get(1);
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[]parent = new int[n];
        parent[0]=-1;
        
        List<List<Integer>> art = new ArrayList<>();
        
        dfs(0, adj, new int[n], new int[n],parent,art, new boolean[n], 0);
        return art;
    }
    
    public void dfs(int u, List<List<Integer>> connections, int[]disc,int[]low, int[]parent, 
                    List<List<Integer>> art , boolean[]vis, int time){
        vis[u]=true;
        disc[u]=low[u]=time;
        time++;
        
      for(int i=0;i<connections.get(u).size();i++){
          int v = connections.get(u).get(i);
          
          if(parent[u]==v)
              continue;
          else if(vis[v]==true){
              low[u]=Math.min(low[u],disc[v]);
          }else{
              parent[v]=u;
              dfs(v,connections,disc,low,parent,art,vis,time);
              
              low[u]=Math.min(low[u],low[v]);
              
              if(low[v]>disc[u])
              {
                  ArrayList<Integer> ans = new ArrayList<>();
                  ans.add(u);
                  ans.add(v);
                  art.add(ans);
              }
          }
      }
    }
}