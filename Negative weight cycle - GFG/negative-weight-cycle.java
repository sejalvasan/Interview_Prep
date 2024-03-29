//{ Driver Code Starts
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
            String[] S1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] edges = new int[m][3];
            for(int i = 0; i < m; i++){
                String S2[] = br.readLine().trim().split(" ");
                for(int j = 0; j < 3; j++)
                    edges[i][j] = Integer.parseInt(S2[j]);
            }
            Solution obj = new Solution();
            int ans = obj.isNegativeWeightCycle(n, edges);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int isNegativeWeightCycle(int n, int[][] edges)
    {
        //code here
     int[]path = new int[n];
     Arrays.fill(path, Integer.MAX_VALUE);
     
     path[0]=0;
     
     for(int j =0;j<n-1;j++){
     for(int i =0;i<edges.length;i++){
      int u = edges[i][0];
      int v = edges[i][1];
      int wt = edges[i][2];
      
      if(path[u]==Integer.MAX_VALUE)
      continue;
      
      if(path[u]+wt<path[v])
      path[v]=path[u]+wt;
       }
     }     
    
     for(int i =0;i<edges.length;i++){
      int u = edges[i][0];
      int v = edges[i][1];
      int wt = edges[i][2];
      
       if(path[u]==Integer.MAX_VALUE)
      continue;
      
      if(path[u]+wt<path[v])
      return 1;
     }
     
     return 0;
    }
}