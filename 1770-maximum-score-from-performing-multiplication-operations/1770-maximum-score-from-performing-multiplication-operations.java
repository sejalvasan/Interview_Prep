class Solution {
    
    int dp[][] = new int[1001][1001];
    
    public int maximumScore(int[] nums, int[] multipliers) {
        
        for(int i=0; i<dp.length;i++){
            for(int j =0; j<dp[0].length;j++){
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        
        return helper(0,nums,multipliers,0);
    }
    
    public int helper(int i, int[]nums, int[] m, int s){
        
        if(i == m.length) return 0;
        
        if(dp[i][s]!= Integer.MIN_VALUE) return dp[i][s];
        
        int e = nums.length-(i-s)-1;
        
        int op1 = m[i]*nums[s] + helper(i+1, nums, m, s+1);
        int op2 = m[i]*nums[e] + helper(i+1, nums, m, s);
        
        return dp[i][s]=Math.max(op1,op2);
    }
}