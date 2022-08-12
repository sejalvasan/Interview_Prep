class Solution {
    public int findPeakElement(int[] nums) {
    
        int lo=0, hi = nums.length-1;
        
        while(lo<hi){
            int mid = lo+(hi-lo)/2;
            //decresing part
            if(nums[mid]>nums[mid+1])
                hi = mid;
            else
                //increasing part
                lo = mid+1;
        }
        
        return lo;
        
    }
}