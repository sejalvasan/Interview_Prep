class Solution {
    public int maxProfit(int[] prices) {
        int buy =0;
        int sell =0;
        int profit =0;
        
        for(int i =1;i<prices.length;i++){
            if(prices[i]>=prices[i-1])
                sell++;
            else {
                profit+=prices[sell]-prices[buy];
                sell = buy = i;
            }
        }
        //
        //[1,2,3,4,5]
        profit+=prices[sell]-prices[buy];
        return profit;
    }
}