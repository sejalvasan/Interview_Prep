// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int dp[][]= new int[500][500];
    static int palindromicPartition(String str)
    {
        // code here
        for(int i =0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(str,0,str.length()-1);
    }
    
    static int solve(String str, int i, int j){
        
        if(i>=j)
        return 0;
        if(isPalindrome(str,i,j)==true)
        return 0;
        
        if(dp[i][j]!=-1)
        return dp[i][j];
        int min=Integer.MAX_VALUE;
        
        for(int k = i; k<j ;k++){
        int temp = solve(str, i, k)+solve(str,k+1,j)+1;
           if(temp< min)
           min =temp;
        }
        dp[i][j]=min;
        return dp[i][j];
    }
    
    static boolean isPalindrome(String str, int i, int j){
        
        while(i<j){
            
            if(str.charAt(i)!=str.charAt(j))
          return false;
            
            i++;j--;
        }
        return true;
    }
}