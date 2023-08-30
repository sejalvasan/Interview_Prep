//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;


// } Driver Code Ends
//User function Template for Java

class Solution
{
    //Function to return the total number of possible unique BST.
    static int numTrees(int n)
    {
        // Your code goes here
        
   if(n==0 || n==1){
            return 1;
        }
        
        long dp[]=new long[n+1],mod=(long)(1e9)+7;
        // Initializing dp[0] and dp[1] as 1
        dp[0]=dp[1]=1;
        
        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
                dp[i] = (dp[i]+(dp[j]*dp[i-j-1])%mod)%mod;
            }
        }
        
        //returning the nth catalan number.
        return (int)dp[n];
    }
}


//{ Driver Code Starts.

class GFG
{
    public static void main(String args[])
    {
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            //taking n
            int n =sc.nextInt();
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling method numTrees() of 
            //class Solution
            System.out.println(ob.numTrees(n));
        }
    }
}

// } Driver Code Ends