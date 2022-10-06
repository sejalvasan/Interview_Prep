class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[]arr = {1,2,3,4,5,6,7,8,9};
        
       List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0, arr, n, ans, new ArrayList<>(), k); 
        return ans; 
    }
    
    public void findCombinations(int ind, int[]arr, int target, List<List<Integer>>ans, List<Integer> res, int k){
        
       if(target == 0 ) {
           if(res.size()==k)
            ans.add(new ArrayList<>(res)); 
            return; 
        }
        
        for(int i = ind; i < arr.length;i++) {
            if(i > ind && arr[i] == arr[i-1]) continue; 
            if(arr[i]>target) break; 
            
            res.add(arr[i]); 
            findCombinations(i+1, arr, target - arr[i], ans, res, k); 
            res.remove(res.size() - 1); 
        }
    }
}