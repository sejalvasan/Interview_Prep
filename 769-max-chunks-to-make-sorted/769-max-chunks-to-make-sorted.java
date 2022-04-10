class Solution {
    public int maxChunksToSorted(int[] arr) {
        int max = Integer.MIN_VALUE;
        int ans=0;
        
        for(int i =0;i<arr.length;i++){
            if(max<arr[i])
                max= arr[i];
            
            if(i==max)
                ans++;
            
        }
        
        return ans;
    }
}