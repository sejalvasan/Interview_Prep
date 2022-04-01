class Solution {
    public int dominantIndex(int[] nums) {
        
        int max=0;
        int secMax =0;
        int idx=0;
        int i =0;
        
        if(nums.length==1)
            return 0;
        
       while(i<nums.length){
           
            if(max<=nums[i]){
            secMax=max;    
                max=nums[i];
                idx=i;
               
            }
            
           else if(secMax<nums[i]){
                secMax=nums[i];
            }
           i++;
        }
        
        if(max>=2*secMax)
            return idx;
        
        return -1;
    }
}