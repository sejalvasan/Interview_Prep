class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int count=0;
        int i=0;
        int ans=0;
        int j=0;
        int n = nums.length;
           
     while(j<nums.length){
            //between
            if(nums[j]>=left && nums[j]<=right){
                count =j-i+1;
                ans+=count;
            }
             //less than left
            
           else if(nums[j]<left){
                ans+=count;
            }
            
            //greater than right
            else{
                count=0;
                i=j+1;
            }
            
            j++;
            
        }
        return ans;
    }
}



