class Solution{
public int uniquePaths(int m, int n) {
//         int[][]dp = new int[m][n];
        
//         for(int[]row:dp)
//         Arrays.fill(row,-1);
        
//      return countPaths(m,n,0,0,dp);
//     }
    
//         public int countPaths(int m, int n, int i, int j, int[][]dp){
//             //end point
//         if(i==m-1 && j==n-1)
//             return 1;
        
//         if(i>=m || j>=n)
//             return 0;
            
//             if(dp[i][j]!=-1)
//                 return dp[i][j];
        
//             else    
//         return dp[i][j]=countPaths(m,n,i+1,j,dp)+countPaths(m,n,i,j+1,dp);
    
    int N = m+n-2;
    int r = m-1;
    double res = 1;
    
    for(int i =1;i<=r;i++){
        res = res *(N-r+i)/i;
    }
    
    return (int)res;
    }
    
}