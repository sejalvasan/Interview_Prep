class Solution {
    public int numIslands(char[][] grid) {
        
        int m = grid.length;
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
    static int[][]dir = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    
     public void dfs(char[][] grid,boolean[][] visited, int i, int j){
         visited[i][j]=true;
         int m =grid.length;
         int n = grid[0].length;
         
         for(int k=0;k<4;k++){
             int newr = i + dir[k][0];
             int newc = j+ dir[k][1];
             
      if(newr<0 || newc<0 || newr>=m || newc>=n || visited[newr][newc] || grid[newr][newc] == '0') 
           continue;
             
           //  visited[newr][newc] = true;
             dfs(grid,visited, newr,newc);
         }
     }
}