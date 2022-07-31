class Solution {
    public int findDuplicate(int[] nums) {
        
        for(int i =0;i<nums.length;i++){
            
            int correct = i+1;
            if(nums[i]==correct)
                continue;
            if(nums[i]!=correct){
                int num = nums[i]-1;
                if(nums[i]==nums[num])
                  return nums[i];
                else{
                swap(nums,i,nums[i]-1);
                    i--;
                }
            }
        }
        return nums.length;
    }
    
    public void swap(int[]nums, int i, int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}