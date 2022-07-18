class Solution {
    public int numTrees(int N) {
        long[]dp= new long[N+1];
        dp[0]=1;
        dp[1]=1;
        long mod = 1000000007;
        
        for(int i =2;i<=N;i++){
            for(int j = 0;j<i;j++){
                dp[i]+=(dp[j]*dp[i-j-1])%mod;
            }
        }
    return (int)dp[N];
 }
}