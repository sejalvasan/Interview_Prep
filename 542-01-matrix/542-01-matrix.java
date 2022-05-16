class Pair{
    int first;
    int second;
    
    Pair(int first, int second){
        this.first =first;
        this.second =second;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
     int n = mat.length;
        int m =mat[0].length;
        Queue<Pair> que = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0)
                    que.add(new Pair(i,j));
            else
                mat[i][j]=-1;
            }
        }
        
        int dir[][]={{0,1},{1,0},{-1,0},{0,-1}};
        
       while(!que.isEmpty()){
           Pair rem = que.remove();
           for(int i=0;i<4;i++){
               int rdash = rem.first + dir[i][0];
               int cdash = rem.second + dir[i][1];
               
               if(rdash>=0 && cdash>=0 && rdash <n && cdash<m && mat[rdash][cdash]<0){
                   que.add(new Pair(rdash,cdash));
                   mat[rdash][cdash]=mat[rem.first][rem.second]+1;
               }
           }
       }
        return mat;
    }
}