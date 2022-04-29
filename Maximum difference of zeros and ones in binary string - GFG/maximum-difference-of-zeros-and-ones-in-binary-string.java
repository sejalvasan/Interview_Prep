// { Driver Code Starts
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
}// } Driver Code Ends


//User function Template for Java

class Solution {
    int maxSubstring(String S) {
     int ans=0,csum=0;
        
        for(int i =0;i<S.length();i++){
            int val=0;
            
            if(S.charAt(i)=='0')
            val=1;
            else if(S.charAt(i)=='1')
            val=-1;
            
            csum+=val;
            
            // if(csum>0)
            // csum+=val;
             if(ans<csum)
            ans=csum;
            
            // else
            // csum=val;
            if(csum<0)
            csum=0;
            
            // if(ans<csum)
            // ans=csum;
        }
        
        if(ans==0)
        ans=-1;
        
        return ans;
    }
}