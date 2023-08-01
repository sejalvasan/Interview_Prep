//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s = in.readLine();
            int k = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.minValue(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int minValue(String s, int k){
        // code here
        int[]freq = new int[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0;i<26;i++){
            if(freq[i]>0)
            pq.add(freq[i]);
        }
        
        while(!pq.isEmpty() && k-->0){
            int temp = pq.poll();
            temp--;
            pq.add(temp);
        }
        
        int ans = 0;
        
        while(!pq.isEmpty()){
            ans+= Math.pow(pq.poll(),2);
        }
        
        return ans;
    }
}