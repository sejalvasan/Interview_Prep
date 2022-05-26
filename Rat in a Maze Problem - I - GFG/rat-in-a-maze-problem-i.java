// { Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    private static void solve(int i, int j, int a[][], int n, 
    ArrayList<String> ans, String move, 
    int vis[][]) {
        if(i==n-1 && j==n-1) {
            ans.add(move);
            return; 
        }
        // String dir = "DLRU"; 
        // for(int ind = 0; ind<4;ind++) {
        //     int nexti = i + di[ind]; 
        //     int nextj = j + dj[ind]; 
        //     if(nexti >= 0 && nextj >= 0 && nexti < n && nextj < n 
        //     	&& vis[nexti][nextj] == 0 && a[nexti][nextj] == 1) {

        //         vis[i][j] = 1; 
        //         solve(nexti, nextj, a, n, ans, move + dir.charAt(ind), vis, di, dj);
        //         vis[i][j] = 0; 
                
        //     }
        // }
        // downward
        if(i+1<n && vis[i+1][j] == 0 && a[i+1][j] == 1) {
            vis[i][j] = 1; 
            solve(i+1, j, a, n, ans, move + 'D', vis);
        }
        
        // left
        if(j-1>=0 && vis[i][j-1] == 0 && a[i][j-1] == 1) {
            vis[i][j] = 1; 
            solve(i, j-1, a, n, ans, move + 'L', vis);
        }
        
        // right 
        if(j+1<n && vis[i][j+1] == 0 && a[i][j+1] == 1) {
            vis[i][j] = 1; 
            solve(i, j+1, a, n, ans, move + 'R', vis);
        }
        
        // upward
        if(i-1>=0 && vis[i-1][j] ==0 && a[i-1][j] == 1) {
            vis[i][j] = 1; 
            solve(i-1, j, a, n, ans, move + 'U', vis);
        }
          vis[i][j] = 0; 
    }
    public static ArrayList<String> findPath(int[][] m, int n) {
        int vis[][] = new int[n][n];
        for(int i = 0;i<n;i++) {
            for(int j = 0;j<n;j++) {
                vis[i][j] = 0; 
            }
        }
         
        ArrayList<String> ans = new ArrayList<>(); 
        if(m[0][0] == 1) solve(0, 0, m, n, ans, "", vis); 
        return ans; 
    }
}