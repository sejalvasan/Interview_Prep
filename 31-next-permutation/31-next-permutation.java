class Solution {
    public void nextPermutation(int[] nums) {
          int i = nums.length-2;
        
          if(nums.length<=1)
            return;
        
        while(i>=0 && nums[i]>=nums[i+1]) i--;
        if(i>=0){
            int j = nums.length-1;
            while(nums[j]<=nums[i])
                j--;
            swap(nums,i,j);
        }
        reverse(nums,i+1,nums.length-1);
    }
    
    public void swap(int[]nums, int i, int j){
        int temp = nums[i];
        nums[i]= nums[j];
        nums[j]=temp;
    }
    
    public void reverse(int[]nums,int s, int e){
        while(s<=e){
            int temp = nums[s];
            nums[s]=nums[e];
            nums[e]=temp;
            s++;
            e--;
        }
    }
}