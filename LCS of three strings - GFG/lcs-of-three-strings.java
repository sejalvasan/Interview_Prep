// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int n1 = Integer.parseInt(input_line[0]);
            int n2 = Integer.parseInt(input_line[1]);
            int n3 = Integer.parseInt(input_line[2]);
            input_line = read.readLine().trim().split("\\s+");
            String A = input_line[0];
            String B = input_line[1];
            String C = input_line[2];
            Solution obj = new Solution();
            System.out.println(obj.LCSof3(A, B, C, n1, n2, n3));
        }
    } 
} // } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    int LCSof3(String s1, String s2, String s3, int n1, int n2, int n3) 
    { 
        // code here
     char[] X=s1.toCharArray();
    char[] Y=s2.toCharArray();
    char[]Z = s3.toCharArray();
    
      int L[][][] = new int[n1+1][n2+1][n3+1];
 
    /* Following steps build L[m+1][n+1] in bottom up fashion. Note
        that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
    for (int i=0; i<=n1; i++)
    {
    for (int j=0; j<=n2; j++)
    { 
     for(int k =0;k<=n3;k++){
            
        if (i == 0 || j == 0 ||k==0)
            L[i][j][k] = 0;
        else if (X[i-1] == Y[j-1] && X[i-1]==Z[k-1])
            L[i][j][k] = L[i-1][j-1][k-1] + 1;
        else
            L[i][j][k] = Math.max(L[i-1][j][k],(Math.max(L[i][j-1][k],L[i][j][k-1])));
    }
    }
    }
   return L[n1][n2][n3];
 }
}