class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> ans = new ArrayList<>();
        find(0, candidates,target, ans, new ArrayList<>());
        
        return ans;
    }
    
    public static void find(int idx, int[]candidates, int target, List<List<Integer>> ans, ArrayList<Integer> ds){
        
        if(idx==candidates.length){
            if(target ==0){
            ans.add(new ArrayList<>(ds));
            }
            return;
        }
        
        //include
        if(candidates[idx]<=target){
            ds.add(candidates[idx]);
            find(idx, candidates, target - candidates[idx], ans, ds);
            //backtrack
            ds.remove(ds.size()-1);
        }
        
        //not include
        
        find(idx+1,candidates,target,ans,ds);
    }
}