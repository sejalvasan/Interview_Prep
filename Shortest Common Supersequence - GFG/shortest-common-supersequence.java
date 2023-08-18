//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int t=sc.nextInt();
		
		sc.nextLine();
		while(t-->0)
		{
		   //taking String X and Y
		   String S[]=sc.nextLine().split(" ");
		   String X=S[0];
		   String Y=S[1];
		   
		   //calling function shortestCommonSupersequence()
		   System.out.println(new Solution().shortestCommonSupersequence(X, Y, X.length(), Y.length()));
		}
	}




       
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find length of shortest common supersequence of two strings.
    public static int shortestCommonSupersequence(String s1,String s2,int m,int n)
    {
 
    char[] X=s1.toCharArray();
    char[] Y=s2.toCharArray();
    
    int L[][] = new int[m+1][n+1];
 
    /* Following steps build L[m+1][n+1] in bottom up fashion. Note
        that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
    for (int i=0; i<=m; i++)
    {
    for (int j=0; j<=n; j++)
    {
        if (i == 0 || j == 0)
            L[i][j] = 0;
        else if (X[i-1] == Y[j-1])
            L[i][j] = L[i-1][j-1] + 1;
        else
            L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
     }
    }
  
    return (m+n - L[m][n]);
       
    }
}