
class Solution {
    public boolean isBipartite(int[][] graph) {
        
//         List<List<Integer>> adj = new ArrayList<>();
//         for(int i =0;i<n;i++){
//             adj.add(new ArrayList<>());
//         }
        
//         for(int i=0;i<n;i++){
//             int u = graph[i][0];
            
//         }
        
        int n = graph.length;
        
        int[]color = new int[n];
        
        Arrays.fill(color, -1);
        
        for(int i =0;i<n;i++){
            if(color[i]==-1)
                if(bfs(graph,color,i)==false)
                    return false;
        }
        return true;
        
    }
    
    public boolean bfs(int[][]graph,int[]color,int src){
        Queue<Integer> q = new LinkedList<>();
        color[src] = 0;
        q.add(src);
        
        while(!q.isEmpty()){
            Integer node = q.poll();
            for(Integer it: graph[node]){
                if(color[it]==-1){
                    color[it]=1-color[node];
                    q.add(it);
                }else if(color[node]==color[it])
                    return false;
            }
        }
        return true;
    }
}