// { Driver Code Starts
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
            String S[] = read.readLine().split(" ");
            int R = Integer.parseInt(S[0]);
            int C = Integer.parseInt(S[1]);
            String line[] = read.readLine().trim().split("\\s+");
            int matrix[][] = new int[R][C];
            int c = 0;
            for(int i = 0; i < R; i++){
                for(int j = 0; j < C; j++){
                    matrix[i][j] = Integer.parseInt(line[c++]);
                }
            }
            Solution ob = new Solution();
            int ans = ob.median(matrix, R, C);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int median(int matrix[][], int r, int c) {
        // code here     
        int startVal =0;
        int endVal = 2000;
        int n = (r*c)/2;
        while(startVal<=endVal){
        int midVal = (startVal+endVal)/2;
        int ans =0;
        
        for(int i =0;i<r;i++){
            int lo = 0, hi =c-1, mid;
            while(lo<=hi){
            mid = lo+(hi-lo)/2;
            
            if(matrix[i][mid]<=midVal) lo = mid+1;
            else hi = mid-1;
        }
        ans+=lo;
        }
        
        if(ans<=n) startVal = midVal+1;
        else endVal = midVal-1;
        }
        return startVal;
    }
}