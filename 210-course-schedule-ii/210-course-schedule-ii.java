class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
         ArrayList<Integer>[]graph = new ArrayList[numCourses];
        
        for(int i =0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        
        for(int[]req:prerequisites){
            graph[req[1]].add(req[0]);
        }
     //follow kanhs algo
        
        int[]indegree = new int[numCourses];
        
        for(int v =0;v<graph.length;v++){
            for(int n :graph[v])
                indegree[n]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int v=0;v<graph.length;v++){
            if(indegree[v]==0)
                q.add(v);
        }
        
        int[]topo = new int[numCourses];
        int idx = 0;//graph.length-1;
        while(!q.isEmpty()){
            Integer a = q.poll();
            topo[idx]=a;
           // idx--;
            idx++;
            
            for(int n:graph[a]){
                indegree[n]--;
            
            if(indegree[n]==0)
                q.add(n);
                }
        }
        
        if(idx==numCourses)
            return topo;
        
        return new int[]{};
    }
}