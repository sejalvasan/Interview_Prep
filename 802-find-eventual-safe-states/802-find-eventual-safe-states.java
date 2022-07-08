class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<Integer> res = new ArrayList<>();
        int n = graph.length;
        vis = new int[n];
        
        for(int i=0;i<n;i++){
            boolean safe = dfs(i,graph);
            if(safe)
                res.add(i);
        }
        
        return res;
    }
    int vis[];
    
    public boolean dfs(int v, int[][]graph){
        if(vis[v]==2){
            return true;
        }else if(vis[v]==1){
            return false;
        }else{
            vis[v]=1; //marking space in preorder
            
            for(int n: graph[v]){
                boolean isSafeNbr = dfs(n,graph);
                if(isSafeNbr == false)
                    return false;
            }
        
        vis[v]=2; //mainly terminal nodes marking them vis in post order
        return true;
        }
    }
}