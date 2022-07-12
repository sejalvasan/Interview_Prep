class Solution{
public int fib(int n) {
    
       int[]dp = new int[n+1];
    
    Arrays.fill(dp,-1);
    
    return helper(n,dp);
}
    public int helper(int n, int[]dp){
      if (n <= 1)
            return n;

    if(dp[n]!=-1)
        return dp[n];
        
        int nm1 =helper(n - 1,dp);
        int nm2= helper(n - 2,dp);
        
        return dp[n]=nm1+nm2;
  }
}

     //dp
//         int [] arr = new int [31];
        
//         arr[0] = 0;
//         arr[1] = 1;
//         arr[2] = 1;
        
//         for(int i = 3; i < 31; i++) {
//             arr[i] = arr[i-1] + arr[i-2];
//         }
//         return arr[n];
