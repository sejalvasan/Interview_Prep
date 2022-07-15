// { Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int h = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.countBT(h));
        }
    }
}// } Driver Code Ends


//User function Template for Java
class Solution {
  static final int MOD = 1000000007;
    
    public static long countBT(int h) {
        long[] dp = new long[h + 1];
        // base cases
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i = 2; i <= h; i++) 
          dp[i] = (dp[i - 1] * ((2 * dp [i - 2])% MOD + dp[i - 1]) % MOD) % MOD;
            
            return dp[h];
    }
}