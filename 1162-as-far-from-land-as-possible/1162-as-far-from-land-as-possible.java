class Pair{
    int x;
    int y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public int maxDistance(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        
        int level =-1;
                int zeroCount=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1)
                    q.add(new Pair(i,j));
                else{
                    zeroCount++;
                }
            }
        }
        if(zeroCount ==0)
            return -1;
        int[][]dir = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        
        
        while(!q.isEmpty()){
            int size = q.size();
            
            level++;
            while(size-->0){
                Pair rem = q.remove(); 
                for(int k =0;k<4;k++){
                    int row = dir[k][0]+rem.x;
                    int col = dir[k][1]+rem.y;
                    
                    if(row>=0 && col>=0 && row<grid.length && col<grid[0].length && grid[row][col]==0 ){
                        q.add(new Pair(row,col));
                       // zeroCount--;
                        grid[row][col]=1;
                    }
                }
            }
        }
        // if(zeroCount>0)
        //     return -1;
        
        return level;
    }
}