class Solution {
    public int makeConnected(int n, int[][] connections) {
        int e = connections.length;
        
        if(e<n-1)
            return -1;
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        
        for(int[]c:connections){
            adj.get(c[0]).add(c[1]);
            adj.get(c[1]).add(c[0]);
            }
        
        int c =0;
        
        boolean[]vis = new boolean[n];
        
        for(int i=0;i<n;i++){
            if(vis[i]==false)
            {
                c++;
                dfs(adj,vis, i);
            }
        }
        return c-1;
        
    }
    public static void dfs(ArrayList<ArrayList<Integer>> adj, boolean[]vis, int node){
        vis[node]=true;
        for(Integer it:adj.get(node)){
            if(vis[it]==false)
                dfs(adj,vis,it);
        }
    }
}