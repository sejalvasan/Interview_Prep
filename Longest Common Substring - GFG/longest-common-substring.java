//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            
            String S1 = read.readLine().trim();
            String S2 = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestCommonSubstr(S1, S2, n, m));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int longestCommonSubstr(String s1, String s2, int x, int y){
        // code here
        char[] s = s1.toCharArray();
        char[] t = s2.toCharArray();
        int max = 0;
        int[][]dp = new int[x+1][y+1];
        
        for(int i=0;i<=x;i++){
            for(int j=0;j<=y;j++){
                if(i==0 || j==0)
                dp[i][j]=0;
                
                else if(s[i-1] == t[j-1])
                dp[i][j] = 1+dp[i-1][j-1];
                
                else 
                dp[i][j] = 0;
                
                max = Math.max(max, dp[i][j]);
            }
        }
        
        return max;
    }
}