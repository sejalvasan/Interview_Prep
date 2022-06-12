class Solution {
    public int maximumUniqueSubarray(int[] nums) {
     int maxSum=0;
         int curSum=0;
        int i=0,j=0;
        HashSet<Integer> set = new HashSet<>();
        
        while(j<nums.length){
            
            if(set.contains(nums[j])){
               if(nums[i]==nums[j])
                {
                 curSum=curSum-nums[i];
                 set.remove(nums[i]);
                  i++;
               }else{
                curSum=curSum-nums[i];
                   set.remove(nums[i]);
                   i++;
               }
                
            }else{
                set.add(nums[j]);
                curSum+=nums[j];
                if(maxSum<curSum)
                    maxSum = curSum;
                
                j++;
                
            }
        }
        return maxSum;
    }
}