class Solution {
    public int maxProfit(int[] prices) {
        int obsp = -prices[0], ossp = 0, ocsp = 0;
        
        for(int i = 1;i<prices.length;i++){
            int nbsp = 0, nssp = 0, ncsp = 0;
            //buying
            if(ocsp - prices[i]> obsp)
                nbsp = ocsp - prices[i];
            else
                nbsp = obsp;
            
            //selling
            if(obsp + prices[i]> ossp)
                nssp = obsp + prices[i];
            else
                nssp = ossp;
            
            //cool down
            if(ossp>ocsp)
                ncsp = ossp;
            else
                ncsp = ocsp;
            
            ossp=nssp;
            obsp=nbsp;
            ocsp=ncsp;
        }
        return ossp;
    }
}        