class Solution {
    public int majorityElement(int[] nums) {
        int val = nums[0];
        int count =1;
        for(int i =1;i<nums.length;i++){
            if(val==nums[i])
                count++;
            else{
                if(count==0){ //if not available anymore
                  count++;
                    val=nums[i];
                }
                else{
                    count--;
                }
            }
        }
        return val;
    }
}