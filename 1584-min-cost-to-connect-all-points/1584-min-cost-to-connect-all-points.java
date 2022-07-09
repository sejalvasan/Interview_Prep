class Solution {
    public int minCostConnectPoints(int[][] points) {
        
        int n = points.length;
        
        boolean[] visited = new boolean[n];
        int[] cost = new int[n];
        
        Arrays.fill(visited, false);
        Arrays.fill(cost, Integer.MAX_VALUE);
        
        Queue<int[]> queue = new PriorityQueue<>((a,b) -> (a[1] - b[1]));
        
        cost[0] = 0;
        queue.add(new int[]{0, cost[0]});
        
        int sum = 0;
        while(!queue.isEmpty()){
            int[] node = queue.poll();
            int u = node[0];
            if(visited[u] == true)
                continue;
            visited[u] = true;
            sum+= node[1];
            
            for(int j=0;j<n;j++){
                if(visited[j] == false){
                int wt = getCost(u, j, points);
                if(wt < cost[j]){
                    cost[j] = wt;
                    queue.add(new int[]{j, wt});
                }
            }
        }
        }
        return sum;
    }
    
    
    public int getCost(int u, int v, int[][] points){
        int x1 = points[u][0];
        int x2 = points[v][0];
        int y1 = points[u][1];
        int y2 = points[v][1];
        return Math.abs(x1 - x2) + Math.abs(y2 - y1);
    }
}