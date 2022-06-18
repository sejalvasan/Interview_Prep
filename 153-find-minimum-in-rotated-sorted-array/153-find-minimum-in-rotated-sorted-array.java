class Solution {
    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length-1;
        
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            
            int next = (mid+1)%nums.length;
            int prev = (mid+nums.length-1)%nums.length;
              if(nums[lo]<=nums[hi])
                return nums[lo];
            if(nums[prev]>=nums[mid]&&nums[mid]<=nums[next]){
                return nums[mid];
            }
            else if(nums[lo]<=nums[mid])lo = mid+1;
            else if(nums[hi]>=nums[mid]) hi = mid-1;
            
        }
        return -1;
    }
}