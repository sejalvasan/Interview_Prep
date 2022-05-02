class Solution {
    public int longestOnes(int[] nums, int k) {
        int i = 0,j;
        int numZeros = 0;
        int maxLen = Integer.MIN_VALUE;
        
        for(j = 0; j < nums.length; j++){
            
            if(nums[j] == 0)
                numZeros += 1;
            
            while(numZeros > k){
                
                if(nums[i] == 0) 
                    numZeros -= 1;
                
                i += 1;
            }
            
            maxLen = Math.max(j-i+1, maxLen);
        }
        
        return maxLen;
    }
}