class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
           for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for(int i =0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[]vis = new boolean[n];
        
        dfs(adj, source, vis);
        
        if(vis[destination]==true)
            return true;
        
        return false;
    }
    
    public void dfs(ArrayList<ArrayList<Integer>> adj, int src,boolean[]vis){
        vis[src]=true;

        for(int i:adj.get(src)){
            if(!vis[i])
            dfs(adj,i,vis);
        }
    }
}