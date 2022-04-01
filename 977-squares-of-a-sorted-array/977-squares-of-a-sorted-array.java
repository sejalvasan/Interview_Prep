class Solution {
    public int[] sortedSquares(int[] nums) {
     int l=0;
        int []arr = new int[nums.length];
        int r =nums.length-1;
        int k = nums.length-1;
        
        while(l<=r){
            int lsq = nums[l]*nums[l];
            int rsq=nums[r]*nums[r];
            if(lsq>=rsq){
                arr[k]=lsq;
                k--;
                l++;
            }
            else{
                arr[k]=rsq;
                k--;
                r--;
            }
            
        }
        return arr;
    }
}