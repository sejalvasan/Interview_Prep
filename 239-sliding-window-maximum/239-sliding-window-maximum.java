class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
     int n = nums.length;
        
        int premax[] = new int[n];
        int sufmax[] = new int[n];
        
        premax[0]=nums[0];
        sufmax[n-1]=nums[n-1];
        
        for(int i=0;i<n;i++){
            if(i%k==0)
                premax[i]=nums[i];
            else
        premax[i]=Math.max(premax[i-1],nums[i]);
        }
        
        for(int i=n-2;i>=0;i--){
            if((i+1)%k==0)
                sufmax[i]=nums[i];
            else
        sufmax[i]=Math.max(sufmax[i+1],nums[i]);
        }
        
        int[]ans = new int[n-k+1];
        
        ans[0]=sufmax[0];
        
        for(int i=1;i<=n-k;i++){
            ans[i]=Math.max(sufmax[i],premax[i+k-1]);
        }
        return ans;
    }
}