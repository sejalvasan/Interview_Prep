class Solution {
    public int[] productExceptSelf(int[] nums) {
        //T(C)= O(N) SC=O(N)
//     int n = nums.length;
//         int[]prefix=new int[n];
//         int[]suffix = new int[n];
        
//         prefix[0]=nums[0];
//         for(int i=1;i<n;i++){
//             prefix[i]=prefix[i-1]*nums[i];
//         }
        
//          suffix[n-1]=nums[n-1];
//         for(int i=n-2;i>=0;i--){
//             suffix[i]=suffix[i+1]*nums[i];
//         }
        
//         int[]arr = new int[n];
        
//         arr[0]=suffix[1];
//         arr[n-1]=prefix[n-2];
        
//         for(int i =1;i<n-1;i++){
//             arr[i]=prefix[i-1]*suffix[i+1];
//         }
//         return arr;
        
        //TC O(N) SC O(1)
        int n = nums.length;
        int suffixProd =1;
        int[]prefix = new int[n];
         prefix[0]=nums[0];
        for(int i=1;i<n;i++)
           prefix[i]=prefix[i-1]*nums[i];
        
        for(int i =n-1;i>0;i--){
            prefix[i]=prefix[i-1]*suffixProd;
            suffixProd*=nums[i];
        }
        prefix[0]=suffixProd;
        
        return prefix;
    }
}