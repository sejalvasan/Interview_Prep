class Solution {
    public int firstMissingPositive(int[] nums) {
        
        int n = nums.length;
        
        for(int i=0;i<n;i++){
            
            //already in correct pos
            if(i+1 == nums[i])
                continue;
            
            //out of range
            if(nums[i]<1 || nums[i]>n)
                continue;
            
            int idx =i;
            int correct = nums[i]-1;
            
            //handling duplicacy
            if(nums[idx]==nums[correct])
            continue;           
            
            int temp = nums[idx];
            nums[idx] = nums[correct];
            nums[correct] = temp;
            i--;
            
        }
    
    int ans = -1;
    
    for(int i =0;i<n;i++){
        if(nums[i]!=i+1)
            return i+1;
    }
    
    return n+1;
}
}