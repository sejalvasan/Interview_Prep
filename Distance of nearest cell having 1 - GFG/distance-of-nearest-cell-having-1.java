// { Driver Code Starts
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
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}// } Driver Code Ends

class Pair{
    int x;
    int y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        // Code here
        Queue<Pair> q = new LinkedList<>();

        int n = grid.length;
        int m = grid[0].length;
        int [][]dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        int [][]ans = new int[n][m];
        
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                ans[i][j]=Integer.MAX_VALUE-1;
            }
        }
         
        for(int i =0;i<grid.length;i++){
            for(int j =0;j<grid[0].length;j++){
                if(grid[i][j]==1)
                ans[i][j]=0;
                
                q.add(new Pair(i,j));
            }
        }
        
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                Pair rem = q.remove();
                
                for(int i =0;i<4;i++){
                int r = rem.x + dirs[i][0];
                int c = rem.y + dirs[i][1];
                     
                if(r>=0 && c>=0 && r<n && c<m){
                    if(ans[r][c]>ans[rem.x][rem.y]+1){
                        
                        ans[r][c] = ans[rem.x][rem.y] + 1;
                        q.add(new Pair(r,c));
                    }
                }
                }
            }
        }
        return ans;
    }
}