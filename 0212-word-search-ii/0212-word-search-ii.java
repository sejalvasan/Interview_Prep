class Solution {
    
    class TrieNode{
        TrieNode[]children;
        String word;
        
        TrieNode(){
        children = new TrieNode[26];
        }
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        int n = board.length;
        int m = board[0].length;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
              dfs(board,i,j,root,res);
            }
        }
        return res;
    }
    
    public TrieNode buildTrie(String[]words){
        TrieNode root = new TrieNode();
        for(String w: words){
            TrieNode p = root;
            for(char c: w.toCharArray()){
                int idx = c-'a';
                if(p.children[idx]==null)
                    p.children[idx]=new TrieNode();
                
                p=p.children[idx];
            }
            p.word = w;
        }
        return root;
    }
    
    public static void dfs(char[][]board, int i, int j, TrieNode p, List<String> res){
        char c = board[i][j];
        if(c==';'|| p.children[c-'a']==null) return;
        
        p = p.children[c-'a'];
        
        if(p.word!=null){ //found word
            res.add(p.word);
            p.word = null;  //so no duplication - delete it
        }
        
        //vis 
        board[i][j]=';';
        if (i > 0) dfs(board, i - 1, j ,p, res);
        if (j > 0) dfs(board, i, j - 1, p, res);
        if (i < board.length - 1) dfs(board, i + 1, j, p, res);
        if (j < board[0].length - 1) dfs(board, i, j + 1, p, res);
        board[i][j] = c;
    }
}



//TLE
// class Solution {
//      public List<String> findWords(char[][] board, String[] words) {
//          Set<String> hashSet = new HashSet<>();
//          int n = board.length;
//          int m = board[0].length;
//          if(n==0 || m ==0){
//              return new ArrayList<>();
//          }

//          for(String word: words){

//              for(int i=0;i<n;i++){
//                  for(int j=0;j<m;j++){
//                      boolean[][] visited = new boolean[n][m];
//                      if(word.charAt(0) == board[i][j]){
//                          if(dfs(word, 0, i, j, visited, board)){
//                              hashSet.add(word);
//                          }
//                      }
//                  }
//              }
//          }
//          return new ArrayList<>(hashSet);
//      }

//      private boolean dfs(String word, int len, int i, int j, boolean[][] visited, char[][] board){
//          if(len==word.length()){
//              return true;
//          }
//          if(i<0 || j<0 || i>=board.length || j>=board[0].length || word.charAt(len)!=board[i][j] || visited[i][j]){
//              return false;
//          }
//          boolean res = false;
//          visited[i][j] = true;
//          res = dfs(word, len+1, i-1, j, visited, board) ||
//              dfs(word, len+1, i+1, j, visited, board) ||
//              dfs(word, len+1, i, j+1, visited, board) ||
//              dfs(word, len+1, i, j-1, visited, board);

//          visited[i][j] = false;

//          return res;
//      }
//  }
