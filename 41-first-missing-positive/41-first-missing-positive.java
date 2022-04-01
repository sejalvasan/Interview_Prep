class Solution {
    public int firstMissingPositive(int[] nums) {
        
        int i=0;
        while(i<nums.length){
            int correct = nums[i]-1;
            if(nums[i]>0 && nums[i]<=nums.length && nums[i]!=nums[correct])
                swap(i,correct,nums);
            else
                i++;
        }
        
        for(int j=0;j<nums.length;j++){
            if(nums[j]!=j+1)
                return j+1;
        }
        return nums.length+1;
        
    }
        
        public static void swap(int i, int j, int[]arr){
            int temp = arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }
}