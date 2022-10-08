class Solution {
    public int makeConnected(int n, int[][] connections) {
        
        int e = connections.length;
        if(e<n-1)
            return -1;
        
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[]c:connections){
            adj.get(c[0]).add(c[1]);
            adj.get(c[1]).add(c[0]);
        }
        
        int comp = 0;
        boolean[]vis = new boolean[n];
        
        for(int i =0;i<n;i++){
            if(vis[i]==false){
                comp++;
                dfs(i,vis,adj);
            }
        }
        
        return comp-1;
    }
    
    public void dfs(int node, boolean[]vis, List<List<Integer>> adj){
        vis[node] = true;
        
        for(Integer it: adj.get(node)){
            if(vis[it]==false)
                dfs(it,vis,adj);
        }
    }
}