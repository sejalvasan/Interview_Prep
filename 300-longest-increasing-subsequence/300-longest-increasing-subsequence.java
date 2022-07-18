class Solution {
    public int lengthOfLIS(int[] nums) {
//         int[]lis = new int[nums.length];
        
//         Arrays.fill(lis,1);
//         int max = 1;
//         for(int i =0;i<nums.length;i++){
//             for(int j =0;j<i;j++){
//                 if(nums[i]>nums[j] && lis[i]<lis[j]+1)
//                     lis[i]=lis[i]+1;
                
//                 max = Math.max(max,lis[i]);
//             }
//         }
        
//         return max;
//     }
// }
        int n = nums.length;
        int[]tail = new int[n];
        tail[0]=nums[0];
        
        int lastIndex =0;
        
        for(int i =1;i<n;i++){
            int index = find(tail,0,lastIndex,nums[i]);
            
            tail[index]=nums[i];
            
            lastIndex = Math.max(index,lastIndex);
        }
        
        return lastIndex+1;
    }
    
    public int find(int[]nums, int l, int h, int val){
        
        if(val>nums[h])
            return h+1;
        
        while(l<h){
            int mid = (h+l)/2;
            
            if(nums[mid]==val)
                return mid;
                
             else if(nums[mid]<val)
                 l = mid+1;
            else
                h = mid;
        }
        
        return h;
    }
}