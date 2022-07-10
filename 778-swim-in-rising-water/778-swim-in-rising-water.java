 class Pair{
    int row;
    int col;
    int val;
    
    Pair(int row, int col, int val){
        this.row = row;
        this.col=col;
        this.val=val;
    }
    // @Override
    // public int compareTo(Pair o){
    //    return this.val - o.val;
    // }
}
class Solution {
    public int swimInWater(int[][] grid) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.val - b.val);
        pq.add(new Pair(0,0,grid[0][0]));
        int n = grid.length;
        boolean[][] vis = new boolean[n][n];
        int[][]dir = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        
        while(!pq.isEmpty()){
        Pair rem = pq.remove();
            
            if(vis[rem.row][rem.col] == true)
                continue;
            
            if(rem.row ==n-1 && rem.col==n-1)
                return rem.val;
            
            vis[rem.row][rem.col]=true;
            
            for(int i=0;i<4;i++){
                int rowdash = rem.row+ dir[i][0];
                int coldash = rem.col + dir[i][1];
                
                if(rowdash<0 || coldash<0 || rowdash>=n || coldash>=n || vis[rowdash][coldash]==true)
                    continue;
                
                pq.add(new Pair(rowdash,coldash,Math.max(grid[rowdash][coldash], rem.val)));
            }
        
        }
        return 0;
    }
}