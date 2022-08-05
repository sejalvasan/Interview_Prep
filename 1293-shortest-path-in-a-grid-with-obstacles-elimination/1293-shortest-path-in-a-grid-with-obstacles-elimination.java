class Pair{
    int x;
    int y;
    int val;
    
    Pair(int x, int y, int val){
        this.x = x;
        this.y = y;
        this.val = val;
    }
}
class Solution {
    
    static int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    
    public int shortestPath(int[][] grid, int k) {
       Queue<Pair> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        
        boolean[][]vis = new boolean[m][n];
        
        int[][]obstacle = new int[m][n];
        q.add(new Pair(0,0,grid[0][0]));
        vis[0][0]=true;
        obstacle[0][0]=grid[0][0];
        int level =0;
        
        while(!q.isEmpty()){
            int size = q.size();
            
            while(size-->0){
                Pair rem = q.remove();
                if(rem.x==m-1 && rem.y ==n-1)
                    return level;
                
                int currentObstacle = rem.val;
                
                for(int i=0;i<4;i++){
                    int r = rem.x+ dirs[i][0];
                    int c = rem.y + dirs[i][1];
                    
                    if(r<0 || c<0 || r>=m || c>=n)
                        continue;
                    
                    int oldObstacle = obstacle[r][c];
                    int newObstacle = grid[r][c] + currentObstacle;
                    
                    if((!vis[r][c] && newObstacle<=k)){
                        q.add(new Pair(r,c,newObstacle));
                        vis[r][c]=true;
                        obstacle[r][c]= newObstacle;
                    }
                    
                    if((oldObstacle>newObstacle) && (newObstacle <=k)){
                         q.add(new Pair(r,c,newObstacle));
                        vis[r][c]=true;
                        obstacle[r][c]= newObstacle;
                    }
                }
            }
            level++;
        }
        return -1;
    }
}