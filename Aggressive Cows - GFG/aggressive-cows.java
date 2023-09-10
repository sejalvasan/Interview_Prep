//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n;
            n = sc.nextInt();

            int k;
            k = sc.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) v[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.solve(n, k, v);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        int hi = stalls[n-1] - stalls[0];
        int lo = 1;
        int ans = -1;
        
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            if(canPlace(stalls, k, mid)){
                ans = mid;
                lo = mid+1;
            }else{
                hi = mid-1;
            }
        }
        
        return ans;
    }
    
    public static boolean canPlace(int[]stalls, int cows, int dist){
        int coord = stalls[0], cnt = 1;
        
        for(int i=1;i<stalls.length;i++){
            if(stalls[i]-coord>=dist){
                cnt++;
                coord = stalls[i];
                
                if(cnt==cows)
                return true;
            }
        }
        
        return false;
    }
}