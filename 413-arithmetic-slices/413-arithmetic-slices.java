class Solution {
    public int numberOfArithmeticSlices(int[] arr) {
 
        int n = arr.length;
        int[]dp = new int[n];
        int ans =0;
        
        for(int i =2;i<n;i++){
            if(arr[i]-arr[i-1]==arr[i-1]-arr[i-2]){
                dp[i]=dp[i-1]+1;
                ans+=dp[i];
            }
        }
        
        return ans;
    }
}