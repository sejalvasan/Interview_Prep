class Solution {
    private class Pair{
        int row;
        int col;
        
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    
    public int shortestBridge(int[][] grid) {
        // store the index of land (row and col == 1);
        Queue<Pair> queue = new LinkedList<>();
        // check that next curr or next is visited or not
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        // this is use of dfs only 
        // means only apply dfs logic once 
        // and store all the land in Qeueu 
        boolean found = false;
        
        // dfs for storing all the row and col in Queue
        // only go once because in question they mention that Exactly Two IsLand
        for(int i = 0; i < grid.length && !found; i++){
            for(int j = 0; j < grid[0].length && !found; j++){
                if(grid[i][j] == 1){
                    dfs(grid, visited, i, j, queue);
                    found = true;
                }
            }
        }
        
        // after dfs you have this in Queue;
        // queue = [[0,0],[0,1],[1,0],[1,1],[2,0],[2,1]] -> all the ones land (one IsLand) :)
        
        // count of flip 0 to 1 :)
        int minStepToNextIsland = 0;
        
        // bfs for finding the nbr are equal to 1 if yes then return ans
        // else add that row and col in queue
        
        while(!queue.isEmpty()){
            int sz = queue.size();
            // for traveling all the isLand that are present in Queue
            // until queue size is zero;
            while(sz-- > 0){
                // pick the pair val where there are row and col
                Pair rem = queue.poll();
                
                // go to there directions in all four diection(Up, Down, Right, Left);
                for(int []d : dir){
                    int x = d[0] + rem.row;
                    int y = d[1] + rem.col;
                    
                    // checking that x( next row) and y (next col) are not go out of Bound
                    // and also check that next row and next col are not visited
                    // and if you find 1 in next row or next col return ans;
                    // else add it in queue
                    // and also visited the value as true
                    
                    if(x >=0 && y >=0 && x < grid.length && y < grid[0].length && !visited[x][y]){
                        // case like this [1  1  0  0  1 ] 
                        // where after two zero there next nbr is 1
                        // means there is bridge and you have to return straight away
                        // 1.e ans is 2
                        if(grid[x][y] == 1)
                            return minStepToNextIsland;
                        //its an unvisited zero
                        queue.offer(new Pair(x, y));
                        visited[x][y] = true;
                    }
                }
            }
                // you come here only if size of queue is zero
                // if there are still left in queue then again while loop is executed
                // at this point Queue is look like
                // Queue = [[0,2], [1,2], [2,2]]; -> all the nbr zero which i want to make them 1 :)
                minStepToNextIsland++;
        }
        return -1;        
    }
    
    private int[][] dir = new int [][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
    
    // this is a simple dfs
    private void dfs(int[][] grid, boolean[][] visited, int i, int j, Queue<Pair> queue){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length|| visited[i][j] || grid[i][j] == 0){
            return;
        }
        
        visited[i][j] = true;
        // storing all the row and col of grid[i][j] == 1;
        queue.offer(new Pair(i, j));
        
        for(int []d : dir){
            dfs(grid, visited, d[0]+i, d[1]+j, queue);
        }
    }
}