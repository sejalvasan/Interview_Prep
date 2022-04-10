class Solution {
    public int maxProduct(int[] nums) {
        
        int n = nums.length;
       if(n == 1)    return nums[0];

        int max =Integer.MIN_VALUE;
        int mul =1;
        
        for(int i=0;i<n;i++){
               mul*=nums[i];
            max = Math.max(max, mul);
            if( mul == 0 ) 
                mul = 1;
        }
     
        mul = 1; 
        for(int i=n-1; i>=0; i--){
            
            mul *= nums[i];
            max = Math.max(max, mul);
            if( mul == 0 ) 
                    mul = 1;             
        }        
        return max;
    }
}