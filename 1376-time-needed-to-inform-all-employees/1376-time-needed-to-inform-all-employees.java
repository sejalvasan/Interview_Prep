class Solution {
    
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i =0;i<n;i++){
            int parent = manager[i];
            if(parent!=-1)
            adj.get(parent).add(i);
        }
        
        dfs(headID,informTime);
     return max;   
    }
    
    int max =0, ans=0;

    public void dfs(int headID, int[] informTime){
            max = Math.max(max,ans);

        for(Integer it: adj.get(headID)){
            ans += informTime[headID];
            dfs(it,informTime);
            
            //backtrack
            ans-=informTime[headID];
        }
    }
}