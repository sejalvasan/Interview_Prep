class Solution {
    public List<List<Integer>> combine(int n, int k) {
        int[]arr = new int[n];
        for(int i =0;i<n;i++)
            arr[i]=i+1;
        
        helper(arr,k,0,new ArrayList<>());
        
        return list;
    }
    
    List<List<Integer>> list = new ArrayList<>();
    
    public void helper(int[]arr, int k, int idx, List<Integer> ans){
        
        if(ans.size()==k){
            list.add(new ArrayList(ans));
            return;
        }
        
        for(int i = idx;i<arr.length;i++){
            ans.add(arr[i]);
            helper(arr,k,i+1, ans);
            ans.remove(ans.size()-1);
        }
    }
}