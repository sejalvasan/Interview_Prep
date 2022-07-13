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
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.LongestRepeatingSubsequence(str);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestRepeatingSubsequence(String str)
    {
    char[] X=str.toCharArray();
    char[] Y=str.toCharArray();
    int m = str.length();
      int L[][] = new int[m+1][m+1];
 
    /* Following steps build L[m+1][n+1] in bottom up fashion. Note
        that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
    for (int i=1; i<=m; i++)
    {
    for (int j=1; j<=m; j++)
    {
          if (X[i-1] == Y[j-1] && i!=j)
            L[i][j] = L[i-1][j-1] + 1;
        else
            L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
    }
    }
   return L[m][m];
 }
}