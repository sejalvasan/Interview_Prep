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
            int N = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.TotalWays(N);
            System.out.println(ans);           
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int TotalWays(int N)
    {
        // Code here
        if (N == 1)
            return 4;
            
        long mod = 1000000007;
        long space = 1;
        long build = 1;
        
        for(int i = 2;i<=N;i++){
          long  newSpace = (space + build)%mod;
           long   newBuild = (space)%mod;
           
           space = (newSpace)%mod;
           build = (newBuild)%mod;
        }
        
        long oneRoad = (space+build)%mod;
        long twoRoad =(oneRoad*oneRoad)%mod;
        return (int)(twoRoad);
    }
}