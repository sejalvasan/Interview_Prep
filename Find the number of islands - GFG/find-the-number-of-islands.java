// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends


class Solution {
    // Function to find the number of islands.
    static int[][]dir = new int[][]{{1,0},{0,1},{0,-1},{-1,0},
    {1,1},{1,-1},{-1,-1},{-1,1}};
    public int numIslands(char[][] grid) {
        // Code here
        int n =grid.length;
        int m = grid[0].length;
        boolean[][]vis = new boolean[n][m];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==false && grid[i][j]=='1'){
                    count++;
                dfs(i,j,grid,vis);     
                }
            }
        }
        return count;
    }
    
    public static void dfs(int row, int col, char[][]grid, boolean[][]vis){
        vis[row][col]=true;
        
        for(int i=0;i<8;i++){
            int nr = row + dir[i][0];
            int nc = col + dir[i][1];
            
            if(nr<0 || nc<0 || nr>=grid.length
            || nc>=grid[0].length ||vis[nr][nc]==true||grid[nr][nc]=='0')
            continue;
            
            vis[nr][nc]=true;
            dfs(nr,nc,grid,vis);
        }
        
        
    }
}