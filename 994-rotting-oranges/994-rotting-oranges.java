
class Solution {
    class Pair{
    int x;
    int y;
    Pair(int x, int y){
        this.x = x;
        this.y =y;
    }
}
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        
        int c1=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2)
                    q.add(new Pair(i,j));
                else if(grid[i][j]==1)
                    c1++;
            }
        }
        if(c1==0)
            return 0;

     int dir[][] =new int[][] {{1,0},{0,1},{-1,0},{0,-1}};
        
        int level=-1;
        while(q.size()>0){
            int size = q.size();
               level++;

            while(size-->0){
                Pair rem = q.remove();
                for(int i=0;i<4;i++){
                int row = rem.x+dir[i][0];
                int col = rem.y+dir[i][1];
                    
                    if(row>=0 && col>=0 && row<grid.length && col<grid[0].length && grid[row][col]==1){
                        q.add(new Pair(row,col));
                        grid[row][col]=0;
                        c1--;
                    }
                    
                }
            }
        }
        
        
        if(c1!=0)
            return -1;
        
        return level;
    }
}