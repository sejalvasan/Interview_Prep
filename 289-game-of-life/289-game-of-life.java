class Solution {
    
    int[][]dirs = new int[][]{{1,0},{0,1},{1,1},{-1,-1},{-1,0},{0,-1},{-1,1},{1,-1}};
    
    public void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        
for(int i =0;i<n;i++){
    for(int j=0;j<m;j++){
        if(board[i][j]==1){
            int neigh = findNeigh(board,i,j);
            if(neigh<2 ||neigh>3)
                board[i][j]=-2;
        }else if(board[i][j]==0){
            int neigh = findNeigh(board,i,j);
            if(neigh==3)
                board[i][j]=3;
        }
    }
}        
        updateBoard(board,n,m);
        
    }
    
    public int findNeigh(int[][]board,int row, int col){
        int active =0;
        
        for(int i=0;i<8;i++){
            int x = row+dirs[i][0];
            int y = col+dirs[i][1];
            
            if(x>=0 && y>=0 && x<board.length && y<board[0].length && (board[x][y]==1 || board[x][y]==-2))
                active++;
        }
        return active;
    }
    public void updateBoard(int[][]board, int n, int m){
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==-2)
                    board[i][j]=0;
                
                if(board[i][j]==3)
                    board[i][j]=1;
            }
        }
    }
}