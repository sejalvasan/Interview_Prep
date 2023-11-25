//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            char [][] board = new char[n][m];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    board[i][j] = s[j].charAt(0);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(board, word);
            if(ans)
                System.out.println("1");
            else
                System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution
{
    public boolean isWordExist(char[][] board, String word)
    {
        // Code here
        int n = board.length;
        int m = board[0].length;
        boolean[][]vis = new boolean[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(word.charAt(0)==board[i][j]){
                    if(check(board, word, i, j, vis, 0, n,m)==true)
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean check(char[][]board, String word, int i, int j, boolean[][]vis, int idx, int n, int m){
        
        if(idx==word.length())
        return true;
        
        if(i>=0 && j>=0 && i<n && j<m && word.charAt(idx)==board[i][j] && vis[i][j]==false){
         vis[i][j]=true;
         
         if(check(board, word, i+1, j, vis,idx+1, n,m)||
         check(board,word, i-1, j,vis, idx+1,n,m)||
         check(board,word, i, j+1, vis, idx+1, n,m)||
         check(board,word, i, j-1, vis,idx+1 ,n,m)==true)
         return true;
         
         vis[i][j]=false;
        }
        
        return false;
    }
}