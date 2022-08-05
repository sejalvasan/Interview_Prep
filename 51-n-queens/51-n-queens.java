class Solution {
    List<List<String>> res = new ArrayList<>();
    
    public List<List<String>> solveNQueens(int n) {
        
        char[][]board = new char[n][n];
        
        for(int i =0;i<n;i++){
            for(int j =0;j<n;j++){
                board[i][j]='.';
            }
        }
        
        int[]left = new int[n];
        int down[] = new int[2*n-1];
        int up[] = new int[2*n-1];

        solve(0,n,board,left,down,up);
        return res;
    }
    
    public void solve(int col, int n, char[][]board, int[]left, int down[], int[]up){
        
        if(col==n){
            res.add(construct(board));
            return;
        }
        
        for(int row=0;row<n;row++){
            if(left[row]==0 && down[row+col]==0 && up[n-1+col-row]==0){
                board[row][col]='Q';
                left[row]=1;
                up[n-1+col-row]=1;
                down[row+col]=1;
                solve(col+1,n,board,left,down,up);
                 board[row][col]='.';
                left[row]=0;
                up[n-1+col-row]=0;
                down[row+col]=0;
            }
        }
    }
    
    public List<String> construct(char[][]board){
        List<String> ans = new ArrayList<>();
        
        for(int i =0;i<board.length;i++){
            String s = new String(board[i]);
            ans.add(s);
        }
        return ans;
    }
}