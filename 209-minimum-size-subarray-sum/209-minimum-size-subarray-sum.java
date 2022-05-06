class Solution {
    public int minSubArrayLen(int target, int[] nums) {
    
        int j=0; //start counter
        int sum=0;
        int minlength=Integer.MAX_VALUE;
        
      for(int i=0;i<nums.length;i++){
          sum+=nums[i];
          while(sum>=target){
            minlength=Math.min(minlength,(i-j+1));
              sum-=nums[j];
              j++;
          }
      }
        
        return minlength==Integer.MAX_VALUE?0:minlength;
    }
}