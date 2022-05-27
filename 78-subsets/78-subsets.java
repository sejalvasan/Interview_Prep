class Solution {
    public List<List<Integer>> subsets(int[] nums) {
    
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        dfs(nums, subsets, 0, new ArrayList<>());
        return subsets;
    }
    
    void dfs(int[] nums, List<List<Integer>> subsets, int idx, List<Integer> subset){
        
        subsets.add(new ArrayList<>(subset));
        
        for(int i=idx; i < nums.length; i++){
            if(i != idx && nums[i] == nums[i-1])
                continue;
            subset.add(nums[i]);
            dfs(nums, subsets, i+1, subset);
            subset.remove(subset.size() - 1);
        }
    }
}