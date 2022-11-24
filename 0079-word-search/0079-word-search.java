class Solution {
    public boolean exist(char[][] board, String word) {
        return exists(board,word);
      }
    
    public static boolean exists(char board[][], String word){
        int n = board.length;
        int m = board[0].length;
        int idx =0;
        boolean[][]vis = new boolean[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==word.charAt(idx)){
                   if( dfs(board, word,vis,i, j, idx))
                       return true;
                }
            }
        }
        return false;
    }
    
    public static boolean dfs(char board[][], String word, boolean[][]visited, int row, int col, int idx){
          
        if(idx==word.length())
        return true;
        
        if(row>=0 && row<board.length && col>=0 && col<board[0].length 
        && visited[row][col]==false && board[row][col]==word.charAt(idx)){
           
            visited[row][col]=true;
            
           if(
           dfs(board,word,visited,row,col+1, idx+1) ||
           dfs(board,word,visited,row+1,col, idx+1) ||
           dfs(board,word,visited,row,col-1, idx+1) ||
           dfs(board,word,visited,row-1,col, idx+1))
           
           return true;
           
           //backtrack
           visited[row][col]=false;
        }
        return false;
        
    }}