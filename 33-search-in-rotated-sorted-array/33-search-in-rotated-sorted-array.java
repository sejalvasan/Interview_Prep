class Solution {
    public int search(int[] arr, int target) {
        
int index = findMin(arr);
    int firstHalf = binarySearch(arr, 0, index-1,target);
        if(firstHalf!=-1)
            return firstHalf;
        int secondHalf = binarySearch(arr, index, arr.length-1,target);
        return secondHalf;
        }
    
     public int findMin(int[] nums) {
        int n = nums.length;
         int lo=0;
        int hi =n-1;
         
        while(lo<=hi){
            
            int mid = lo+(hi-lo)/2;
            int prev = (n+mid-1)%n;
            int next=(mid+1)%n;
            
            if(nums[lo]<=nums[hi])
                return lo;
            
            if(nums[mid]<=nums[prev] && nums[mid]<=nums[next])
                return mid;
            
            else if(nums[lo]<=nums[mid])
                lo=mid+1;
            else
                hi=mid-1;
        }
        return -1;
    }
    public int binarySearch(int[]nums, int lo, int hi, int x){
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            if(nums[mid]==x)
                return mid;
            else if(x<=nums[mid])
                hi=mid-1;
           
            else 
               lo=mid+1;;
        }
        return -1;
    }
}
