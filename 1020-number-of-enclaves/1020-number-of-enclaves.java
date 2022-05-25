class Solution {
    static int[][]dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
       
        for(int i=0;i<n;i++){
         for(int j=0;j<m;j++){
             if(i==0 || j==0 || i==n-1 || j==m-1)
             if(grid[i][j]==1){
                 dfs(i,j, grid);
             }
         }   
        }
        
        int count =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1)
                   count++;
            }
        }
        return count;
    }
    
    public static void dfs(int r, int c , int[][]grid){
        grid[r][c]=0;
       for(int i=0;i<4;i++){
            int nr = r+dirs[i][0];
            int nc = c+dirs[i][1];
                
                if(nr<0 || nc<0 || nr>=grid.length || nc>= grid[0].length || grid[nr][nc]==0)
                    continue;
                grid[nr][nc]=0;
           dfs(nr, nc, grid);
            }
        }
}