class Solution {
    public int maxProfit(int[] prices, int fee) {
     int ossp = 0; 
        int obsp = - prices[0];
        
        for(int i = 1;i<prices.length;i++){
            int nssp = 0, nbsp = 0;
            //buying
            if(ossp - prices[i]> obsp)
                nbsp = ossp - prices[i];
            else
                nbsp = obsp;
            
            //selling
            if(obsp + prices[i] - fee> ossp)
                nssp = obsp + prices[i] - fee;
            else
                nssp = ossp;
            
            ossp = nssp;
            obsp = nbsp;
        }
        return ossp;
    }
}