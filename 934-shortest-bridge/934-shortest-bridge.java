class Pair{
    int x;
    int y;
    Pair(int x, int y){
        this.x = x;
        this.y =y;
    }
}
class Solution {
    static int [][]dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        Queue<Pair> q = new LinkedList<>();
        boolean[][]vis = new boolean[n][m];
        boolean found = false;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==false && grid[i][j]==1){
                    if(found == false){
                     found = true;
                    q.add(new Pair(i,j));
                    dfs(i,j, grid,vis,q);
                    }
                }
            }
        }
        
        int minsteps =0;
        
        while(!q.isEmpty()){
            int size = q.size();

            while(size-->0){
                Pair rem = q.remove();
                
                for(int i=0;i<4;i++){
                    int r = rem.x + dirs[i][0];
                    int c = rem.y + dirs[i][1];
                    
                    if(r<0 || c< 0 || r>=n|| c>=m ||vis[r][c]==true)
                        continue;
                    
                    //mark zeroes visited 
                    if(grid[r][c]==1)
                        return minsteps;
                    vis[r][c]=true;
                    q.add(new Pair(r,c));
                }
            }
               minsteps++;
        }
        return minsteps;
    }
    
    public static void dfs(int i, int j, int[][]grid, boolean[][]vis,Queue<Pair> q){
        vis[i][j]=true;
        
        for(int k=0;k<4;k++){
            int r = i+ dirs[k][0];
            int c = j+ dirs[k][1];
            
            if(r<0 || c<0 || r>=grid.length || c>= grid[0].length || grid[r][c]==0 || vis[r][c]==true)
                continue;
            //its a 1
           vis[r][c]=true;
            q.add(new Pair(r,c));
            dfs(r,c,grid,vis,q);
        }
    }
}