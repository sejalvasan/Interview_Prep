// { Driver Code Starts
//Initial Template for Java

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
            String s = br.readLine().trim();
            String []S = s.split(" ");
            int N = Integer.parseInt(S[0]);
            int start_x = Integer.parseInt(S[1]);
            int start_y = Integer.parseInt(S[2]);
            int step = Integer.parseInt(S[3]);
            Solution ob = new Solution();
            double ans = ob.findProb(N, start_x, start_y, step);
            System.out.println(String.format("%.6f", ans));           
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public double findProb(int n, int r, int c, int k)
    {
        // Code here
	    double[][] dp1 = new double[n][n];
		double[][] dp2 = new double[n][n];
		int[][] moves = { { 1, 2 }, { 2, 1 }, { -1, 2 }, { 1, -2 }, { -2, 1 }, { 2, -1 }, { -1, -2 }, { -2, -1 } };
		dp1[r][c] = 1;
		double factor = 8.0;
		for (int i = 0; i < k; i++) {
			for (int row = 0; row < n; row++) {
				for (int col = 0; col < n; col++) {
					if (dp1[row][col] > 0.0) {
						for (int move = 0; move < moves.length; move++) {
							int nr = row + moves[move][0];
							int nc = col + moves[move][1];
							if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
								dp2[nr][nc] += dp1[row][col] / factor;
							}
						}
					}
				}
			}
			dp1 = dp2;
			dp2 = new double[n][n];
		}

		double ans = 0.0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				ans += dp1[i][j];
			}
		}
		return ans;
    }
}