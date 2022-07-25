class Solution {
    public int[] searchRange(int[] nums, int target) {
     
        int[]ans = new int[2];
        
        int first = search(nums,target,true);
        int last = search(nums,target,false);
     
        ans[0]=first;
        ans[1]=last;
        return ans;
    }
    
    public int search(int[]arr, int target, boolean flag){
        
        int lo =0;
        int hi = arr.length-1;
        int pot =-1;
        
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            
            if(arr[mid]<target){
                lo = mid+1;
            }else if(arr[mid]>target){
                hi = mid-1;
                
            }else{
                 pot = mid;
              if(flag == true){
                  hi = mid-1;
              }else{
                  lo = mid+1;
              }
            }
    }
        return pot;
}
}