// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            long ans = new Solution().countStrings(n);

            System.out.println(ans);
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    long countStrings(int n) {
        // code here
        //include or dont include
       int mod = 1000000007;
//         int[]dp0 = new int[n+1];
//         int[]dp1 = new int[n+1];
        
//         dp0[1]=1;
//         dp1[1]=1;
        
//         for(int i = 2;i<=n;i++){
//             dp1[i]=dp0[i-1];
//             dp0[i]=dp1[i-1]+dp0[i-1];
//         }
        
//         return (dp0[n]+dp1[n])%mod;

//without space

    int old1 = 1;
    int old0 = 1;
    
    for(int i =2;i<=n;i++){
        int new1 = (old0)%mod;
        int new0 = (old1+old0)%mod;
        
        old1 = new1;
        old0 = new0;
    }
    
    return (old1+old0)%mod;
    }
}