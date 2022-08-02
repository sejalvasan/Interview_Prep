class Solution {
    public boolean canFinish(int n, int[][] pre) {
     
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        for(int i=0;i<n;i++)
            graph.add(new ArrayList<>());
        
        int[]indegree = new int[n];
        
        for(int[]a:pre){
            graph.get(a[1]).add(a[0]);
            indegree[a[0]]++;    
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i<n;i++){
            if(indegree[i]==0)
               q.add(i); 
        }
        
        ArrayList<Integer> topo = new ArrayList<>();
        int idx =0;
        while(!q.isEmpty()){
            Integer a = q.poll();
            topo.add(a);
            idx++;
            
            for(int i: graph.get(a)){
                indegree[i]--;
            
            if(indegree[i]==0)
                q.add(i);
            }
        }
        
        if(topo.size()==n)
            return true;
        return false;
    }
}