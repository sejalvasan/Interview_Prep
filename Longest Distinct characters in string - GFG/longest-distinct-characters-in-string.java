//{ Driver Code Starts
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
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestSubstrDistinctChars(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int longestSubstrDistinctChars(String S){
        // code here
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int i=0, j=0;
        int max = -1;
        
        while(j<S.length()){
            char end = S.charAt(j);
            
            map.put(end, map.getOrDefault(end,0)+1);
            if(j-i+1==map.size())
            max = Math.max(max, j-i+1);
            else if(j-i+1>map.size()){
                while(j-i+1>map.size()){
                    char start = S.charAt(i);
                    if(map.get(start)>0){
                        map.put(start, map.get(start)-1);
                        i++;
                    }
                    
                    if(map.get(start)==0)
                    map.remove(start);
                }
            }
            j++;
        }
        
        return max;
        
    }
}