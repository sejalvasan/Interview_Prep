class NumMatrix {
  private int[][]dp;
    public NumMatrix(int[][] matrix) {
        if(matrix==null || matrix.length ==0 || matrix[0].length==0)
            return;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        dp = new int[m+1][n+1];
        
        for(int i=1;i<=m;i++){
            for(int j =1;j<=n;j++){
                dp[i][j]=matrix[i-1][j-1]+dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1];
            }
        }
            
    }
    
    public int sumRegion(int r1, int c1, int r2, int c2) {
        return dp[r2+1][c2+1]-dp[r1][c2+1]-dp[r2+1][c1]+dp[r1][c1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */