class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length<=1)
            return nums.length;
        
        int up=1;
        int down =1;
        
        for(int i =0;i<nums.length-1;i++){
            if(nums[i+1]>nums[i]){
                up=down+1;
            }else if(nums[i+1]<nums[i]){
                down = up+1;
            }
        }
        return Math.max(up,down);
    }
}