//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.maxSubstring(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java



//User function Template for Java

class Solution {
    int maxSubstring(String S) {
        // code here
        int cur=0, ans =0;
        
        for(int i =0;i<S.length();i++){
            
            int val =0;
            if(S.charAt(i)=='0')
            val=1;
            
            if(S.charAt(i)=='1')
            val =-1;
            
            cur+=val;
            
            if(ans<cur)
            ans = cur;
            
            if(cur<0)
            cur = 0;
        }
        
        if(ans==0) return -1;
        
        return ans;
    }
}