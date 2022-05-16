class Solution {
    public int numIslands(char[][] grid) {
        int m= grid.length;
        int n = grid[0].length;
     boolean[][]vis = new boolean[m][n];
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && vis[i][j]==false){
                    dfs(grid,vis,i,j);
                    count++;
                }
            }
        }
        return count;
    }
     public void dfs(char[][] grid,boolean[][] visited, int i, int j){
         int m =grid.length;
         int n = grid[0].length;
         if(i<0 || j<0 || i>=m || j>=n || visited[i][j] || grid[i][j] == '0') return;
        visited[i][j] = true;
        
        dfs(grid,visited,i, j-1);
        dfs(grid,visited,i, j+1);
        dfs(grid,visited,i+1, j);
        dfs(grid,visited,i-1, j);
    }
    
}