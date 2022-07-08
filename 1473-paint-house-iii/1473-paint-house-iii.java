class Solution {
    private int[][][]dp;
    private int max = 1000000000;
    
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        // house id, target, last colour
        dp = new int[m+1][target+1][n+1];
        
        int ans = dfs(houses,cost,0,target,0,n);
        
        return ans==max?-1:ans;
    }
    
    public int dfs(int[] houses, int[][] cost,int i ,int target, int lastColour,int n){
        //not possible
        if(target<0)
            return max;
        
        if(i==houses.length){
            return target==0?target:max;
        }
        
        //already computed
        if(dp[i][target][lastColour]!=0)
            return dp[i][target][lastColour];
        
        //check if current house is painted
        if(houses[i]!=0){
            if(lastColour!=houses[i]){
                target--;
            }
            return dfs(houses,cost,i+1,target,houses[i],n);
        }
        
        int ans = max;
        
        //check for reach and every colour and then find the least cost
        
        for(int colour=1;colour<=n;colour++){
ans = Math.min(ans, cost[i][colour-1]+dfs(houses,cost,i+1,target-((lastColour!=colour)? 1:0),colour,n));
        }
        
        dp[i][target][lastColour]=ans;
        return ans;
    }
}