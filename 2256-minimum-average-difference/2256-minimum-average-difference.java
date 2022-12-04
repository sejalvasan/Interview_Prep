class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        if(n==0)
        return 0;
        
        long[]preSum = new long[n];
        long[]sufSum = new long[n];
        
        preSum[0] = nums[0];
        sufSum[n-1] = nums[n-1];
        
        //filling pre
        for(int i = 1;i<n;i++){
            preSum[i] = nums[i] + preSum[i-1];
        }

        //filling suff
        for(int i = n-2;i>=0;i--){
            sufSum[i] = nums[i] + sufSum[i+1];
        }
        
        long min = Long.MAX_VALUE;
        int idx = -1;
        
        for(int i = 0;i<n;i++){
            long sum1 = preSum[i]/(i+1);
            long sum2 = i==n-1? 0:sufSum[i+1]/(n-i-1);
            
           long a = Math.abs(sum1 - sum2);
            
            if(a<min){
                min = a;
                idx = i;
            }
        }
        
        return idx;
    }
}