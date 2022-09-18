class Solution {
    public int distinctSubseqII(String s) {
        int mod = 1000000007;
        
        long[]dp = new long[s.length()+1];
        int[]lo = new int[26];
        
        dp[0]=1;
        dp[1]=2;
        
        lo[s.charAt(0)-'a']=1;
        
        for(int i =2;i<dp.length;i++){
            
            dp[i]=(dp[i-1]*2)%mod;
            
            int ch = s.charAt(i-1)-'a';
            if(lo[ch]!=0){
                dp[i]= (dp[i]-dp[lo[ch]-1] + mod)%mod;
            }
            
            lo[ch]=i;
        }
        
        return (int)dp[s.length()]-1;
    }
}