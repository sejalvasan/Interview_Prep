class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n =isConnected.length;
        boolean []vis = new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if (vis[i]==false){
                count++;
                dfs(isConnected,vis,i);
            }
        }
        return count;
    }
    
    
    public static void dfs(int[][]isConnected, boolean[]vis, int node){
        for(int j=0;j<isConnected.length;j++){
            if(isConnected[node][j]==1 && vis[j]==false){
                vis[j]=true;
                dfs(isConnected,vis,j);
            }
        }
    }
}