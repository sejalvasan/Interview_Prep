class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int n = queries.length;
        int sum = 0;
        
        for(int i =0;i<nums.length;i++){
           if(nums[i]%2==0)
               sum+=nums[i];
        }
        
        int[]ans = new int[n];
        
        for(int i =0;i<n;i++){
            int val = queries[i][0];
            int ind = queries[i][1];
            
            if(nums[ind]%2==0)
                sum-=nums[ind];
            
            nums[ind]+=val;
            
            if(nums[ind]%2==0)
                sum+=nums[ind];
            
            ans[i]=sum;
        }
        
        return ans;
    }
}