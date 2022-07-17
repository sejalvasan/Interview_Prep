class Solution {
    public int maxProfit(int[] prices) {
        int n =prices.length;
           int min = prices[0];
        int[]dp = new int[n];
        int max1=0;
            for(int i =1;i<n;i++){
            if(prices[i]<min)
                min=prices[i];
            
            max1=prices[i]-min;
                if(max1>dp[i-1])
                    dp[i]=max1;
                else
                    dp[i]=dp[i-1];
        }
        
        int[]dp2=new int[n];
        int max =prices[n-1];
        int max2=0;
        
        for(int i =n-2;i>=0;i--){
            if(max<prices[i])
                max=prices[i];
            
            max2=max-prices[i];
            
            if(max2>dp2[i+1])
                dp2[i]=max2;
            else
                dp2[i]=dp2[i+1];
        }
        
        int ans=0;
        
        for(int i =0;i<n;i++){
            if(ans<dp[i]+dp2[i])
            ans =dp[i]+dp2[i];
        }
        return ans;
        
    }
}