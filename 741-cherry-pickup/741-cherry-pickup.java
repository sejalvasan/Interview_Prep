class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][]dp = new int[n][n][n];
        int ans = cherry(grid,0,0,0,dp,n);
        
        if(ans<0)
            return 0;
        
        return ans;
    }
    
    public int cherry (int[][]grid, int r1, int c1, int r2, int[][][]dp, int n){
        
        int c2 = r1 + c1 - r2;
        
        if(r1>=n || r2>=n || c1>=n || c2>=n || grid[r1][c1]==-1 || grid[r2][c2]==-1)
            return Integer.MIN_VALUE;
        
        //destination
        if(r1==n-1 && c1 == n-1)
            return grid[r1][c1];
        
        if(dp[r1][c1][r2]!=0){
            return dp[r1][c1][r2];
        }
        
        int cherries =0;
        if(r1==r2 && c1 == c2)
            cherries+=grid[r1][c1];
        else
            cherries+=grid[r1][c1]+grid[r2][c2];
        
        int f1 = cherry(grid,r1,c1+1,r2,dp,n); //h h
            int f2 = cherry(grid,r1+1,c1,r2+1,dp,n);//vv
            int f3 = cherry(grid,r1+1,c1,r2,dp,n);//v h
            int f4 = cherry(grid,r1,c1+1,r2+1,dp,n);//h v
            
            cherries += Math.max(f1,Math.max(f2,Math.max(f3,f4)));
        
        dp[r1][c1][r2]=cherries;
        return dp[r1][c1][r2];
    }
}
