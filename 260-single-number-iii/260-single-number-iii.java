class Solution {
    public int[] singleNumber(int[] nums) {
        
        int[]ans = new int[2];
        int totalXor = 0;
        
        for(int val:nums){
            totalXor = totalXor^val;
        }
        
        int rmsb = totalXor & (-totalXor);
        
        int x = 0, y = 0;
        
        for(int val: nums){
            if((val & rmsb)==0)
                x=x^val;
            
            else
                y = y^val;
        }
        
        if(x<y){
            ans[0]=x;
            ans[1]=y;
        }else{
            ans[0]=y;
            ans[1]=x;
        }
        
        return ans;
        
    }
}