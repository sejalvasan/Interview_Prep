class Solution {
    public int[] twoSum(int[] nums, int target) {
    
        HashMap<Integer, Integer> store = new HashMap<>();
    
        for(int i = 0; i < nums.length; i++){
            
            if(!store.containsKey(target-nums[i]))
                store.put(nums[i], i);
            else
                return new int[] {i, store.get(target-nums[i])};
        }
    
        return new int[] {0, 0}; 
    }
}