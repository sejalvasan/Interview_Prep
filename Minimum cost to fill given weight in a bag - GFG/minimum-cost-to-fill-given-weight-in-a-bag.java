// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int w = sc.nextInt();
                    int cost[] = new int[n];
                    for(int i = 0;i<n;i++)
                        cost[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minimumCost(cost,n,w));
                }
        }
}    // } Driver Code Ends


class Solution
{
	public int minimumCost(int cost[], int n,int W)
	{
		// Your code goes here
        ArrayList<Integer> val = new ArrayList<Integer>();
        ArrayList<Integer> wt = new ArrayList<Integer>();
     
        int size = 0;
        for (int i = 0; i < n; i++)
        {
            if (cost[i] != -1)
            {
                val.add(cost[i]);
                wt.add(i + 1);
                size++;
            }
        }
      int mod = 1000000007;
        n = size;
        
		int[][]min_cost= new int[n+1][W+1];
		
		for (int i = 0; i <= W; i++)
            min_cost[0][i] = Integer.MAX_VALUE-1;
      
        // fill 0'th column with 0
        // for (int i = 1; i <= n; i++)
        //     min_cost[i][0] = 0;
      
        // now check for each weight one by one and
        // fill the matrix according to the condition
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= W; j++)
            {
                // wt[i-1]>j means capacity of bag is
                // less then weight of item
                if (wt.get(i-1) > j)
                    min_cost[i][j] = min_cost[i-1][j]%mod;
      
                // here we check we get minimum cost
                // either by including it or excluding
                // it
                else
                    min_cost[i][j] = Math.min(min_cost[i-1][j]%mod,
                                  min_cost[i][j-wt.get(i-1)]%mod +
                                              val.get(i-1)%mod);
            }
        }
      
        // exactly weight W can not be made by
        // given weights
        return (min_cost[n][W] == Integer.MAX_VALUE)? -1:
                                        min_cost[n][W];
	}
}