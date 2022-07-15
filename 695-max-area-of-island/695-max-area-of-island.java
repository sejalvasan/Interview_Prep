class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        
//         int m = grid.length;
//         int n = grid[0].length;
//         boolean[][]vis = new boolean[m][n];
//         int max =0;
//         for(int i =0;i<m;i++){
//             for(int j=0;j<n;j++){
//                 int maxArea = 1;
//                 if(grid[i][j]==1 && vis[i][j]==false){
//                     dfs(grid,i,j,vis,maxArea);
//                     if(max<maxArea)
//                         max = maxArea;
//                 }
//             }
//         }
//       return max;
//     }
    
//    int[][]dirs = new int[][]{{-1,0},{0,-1},{0,1},{1,0}};

//     public void dfs(int[][]grid, int i, int j, boolean[][]vis,int area){
//         vis[i][j]=true;
        
//         int m = grid.length;
//         int n = grid[0].length;
                
//         for(int k =0;k<4;i++){
//             int r = dirs[k][0]+i;
//             int c = dirs[k][1]+j;
            
//             if( r<0 || c<0 || r>=m || c>=m || vis[r][c]==true || grid[r][c]=='0')
//                 continue;
//             area++;
//             dfs(grid,r,c,vis,area);
//         }
//     }
// }
         int rows = grid.length;
        int cols = grid[0].length;
        int maxArea = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1){
                    maxArea = Math.max(maxArea, getCurrentArea(i,j, grid));
                }
            }
        }
        return maxArea;
    }



    private int getCurrentArea(int i,int j, int[][] grid){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]<=0){
            return 0;
        }
        // grid[i][j] = 1
        grid[i][j]=-1;
        int leftArea = getCurrentArea(i,j-1, grid);
        int rightArea = getCurrentArea(i,j+1, grid);
        int upArea = getCurrentArea(i-1,j, grid);
        int downArea = getCurrentArea(i+1,j, grid);

        int totalArea = 1 + leftArea + rightArea +upArea+downArea;

        return  totalArea;

    }
}