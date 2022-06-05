class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int pro=0;
     boolean[]vis = new boolean[n];   
        
        for(int i=0;i<n;i++){
            if(vis[i]==false){
                dfs(vis,isConnected, i);
                pro++;
            }
        }
        return pro;
    }
    
    public static void dfs(boolean[]vis, int[][]isConnected, int i){
        for(int j=0;j<isConnected.length;j++){
            if(vis[j]==false && isConnected[i][j]==1)
            {
                vis[j]=true;
                dfs(vis,isConnected,j);
            }
        }
    }
}