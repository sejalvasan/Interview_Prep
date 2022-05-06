// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            int ans = new Solution().lengthOfLongestAP(a, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int lengthOfLongestAP(int[] arr, int n) {
        // code here
   if(n<=2)
   return n;
   int maxlen =2;
   int [][]dp = new int[n][n];
   
   for(int i=0;i<n;i++)
       //last col 
       //only 2 elements - 1st and last
       dp[i][n-1]=2;
       
       
       for(int j=n-2;j>=1;j--){
           int i=j-1, k=j+1;
           while(i>=0 && k<=n-1){
           //3 cases
           if(arr[i]+arr[k]<2*arr[j]){
               k++;
           }else if(arr[i]+arr[k]>2*arr[j]){
               dp[i][j]=2;
               i--;
           }else{
               dp[i][j]=dp[j][k]+1;
               maxlen=Math.max(maxlen,dp[i][j]);
               i--;
               k++;
           }
           }
           while(i>=0){
               dp[i][j]=2;
               i--;
           }
       }
   
       return maxlen;
        
    }
}
