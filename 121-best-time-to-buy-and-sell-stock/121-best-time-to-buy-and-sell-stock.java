class Solution {
    public int maxProfit(int[] arr) {
        int min = arr[0];
        int ans =0;
        
        for(int i =1;i<arr.length;i++){
         if(arr[i]>min)
            ans=Math.max(arr[i]-min,ans);
            
            else
                min = arr[i];
        }
        return ans;
    }
}