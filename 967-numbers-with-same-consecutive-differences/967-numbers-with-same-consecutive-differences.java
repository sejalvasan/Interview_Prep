class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
     List<Integer> list = new ArrayList<>();
        dfs(n,k,list,0);
        int[]ans = new int[list.size()];
        
        for(int i =0;i<list.size();i++){
            ans[i]=list.get(i);
        }
        
        return ans;
    }
    
    public void dfs(int n , int k, List<Integer> list, int cur){
        
        if(n<=0){
            list.add(cur);
            return;
        }
        
        for(int i =0;i<10;i++){
            if(i==0 && cur==0){
                //leading 0 so skip
                continue;
            }else if(i!=0 && cur ==0){ //base case when cur is 0
                dfs(n-1,k,list,i);
            }else if(Math.abs(cur%10-i)==k)
            dfs(n-1,k,list,cur*10+i);
            
        }
    }
}