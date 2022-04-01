class Solution {
    public int maximumProduct(int[] nums) {
//      Arrays.sort(nums);
//     if(nums.length<3){
//         return -1;
//     }
//         int n = nums.length;
//      int ans1= nums[0]*nums[1]*nums[n-1];
//         int ans2 = nums[n-1]*nums[n-2]*nums[n-3];
        
//         return Math.max(ans1,ans2);
        
        int min1 = Integer.MAX_VALUE;
        int min2 = min1;
        int max1=Integer.MIN_VALUE;
       int max2=max1, max3=max2;
        
        for(int i =0;i<nums.length;i++){
            if(nums[i]>=max1){
                   max3=max2;
                   max2=max1;
                max1=nums[i];
        }
            else if(nums[i]>=max2){
                max3=max2;
                max2=nums[i];
            }
            else if(nums[i]>=max3)
                max3=nums[i];
         
            if(nums[i]<=min1){
                    min2=min1;
                min1=nums[i];
            }
            else if(nums[i]<=min2){
                min2 =nums[i];
            }
        }
        int ans1= min1*min2*max1;
        int ans2 = max1*max2*max3;
        
        return Math.max(ans1,ans2);
    }
}