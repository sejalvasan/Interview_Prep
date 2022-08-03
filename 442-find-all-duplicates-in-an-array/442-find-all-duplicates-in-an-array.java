class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
    
        for(int i=0;i<nums.length;i++){
            int correct = i+1;
            
            if(nums[i]==correct)
                continue;
            
            else{
                int right = nums[i]-1;
                if(nums[right]==nums[i])
                   continue;
                else{
                    swap(nums,i,right);
                    i--;
                }
            }
        }
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1)
                list.add(nums[i]);
        }
        return list;
    }
    
    public void swap(int[]nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}