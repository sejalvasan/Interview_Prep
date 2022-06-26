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
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
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
  //  static int dirs[][]=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
        // Code here
       Queue<Pair> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        
        int count =0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j));
                }else if(grid[i][j]==1)
                    count++;
            }
        }
        
        if(count == 0)
            return 0;
        
        int[][]dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        int level = -1;
        
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                Pair rem = q.remove();
                for(int i=0;i<4;i++){
                int r = rem.x + dirs[i][0];
                int c = rem.y + dirs[i][1];
                
                
                if(r<0 || c<0 || r>=n || c>=m || grid[r][c]==2 || grid[r][c]==0)
                    continue;
                
                count--;
                grid[r][c]=2;
                q.add(new Pair(r,c));
                
            }
            }
            level++;
        }
        
        if(count!=0)
            return -1;
        return level;
    }
}