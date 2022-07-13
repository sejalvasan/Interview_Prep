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
            String[] input = new String[2]; 
            input = br.readLine().split(" "); 
            int m = Integer.parseInt(input[0]); 
            int n = Integer.parseInt(input[1]); 
            Solution ob = new Solution();
            System.out.println(ob.numberOfPaths(m,n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    long numberOfPaths(int m, int n)
    {
         int count[][]=new int[m][n];

    for (int i = 0; i < m; i++)
        count[i][0] = 1;

    for (int j = 0; j < n; j++)
        count[0][j] = 1;

    for (int i = 1; i < m; i++)
    {
        for (int j = 1; j < n; j++)
            count[i][j] = (count[i-1][j]%1000000007 + count[i][j-1]%1000000007)%1000000007; 

    }
    return count[m-1][n-1]%1000000007;
    }
}