class Pair{
    int x;
    int y;
    Pair(int x, int y){
        this.x=x;
        this.y =y;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        Queue<Pair> q = new LinkedList<>();
      
        for(int i =0;i<mat.length;i++){
            for(int j =0;j<mat[0].length;j++){
                if(mat[i][j]==0)
                    q.add(new Pair(i,j));
                else
                    mat[i][j]=-1;
            }
        }
        
        int[][]dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        
        while(!q.isEmpty()){
            Pair rem = q.remove();
            
            for(int i =0;i<4;i++){
                int r = rem.x + dirs[i][0];
                int c = rem.y + dirs[i][1];
                
                 if(r>=0 && c>=0 && r <mat.length && c<mat[0].length && mat[r][c]<0){
                
                mat[r][c]=mat[rem.x][rem.y]+1;
                
                q.add(new Pair(r,c));
                 }
            }
            
        }
        return mat;
    }
}