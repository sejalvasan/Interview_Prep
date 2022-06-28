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
        HashMap<Character, Integer> mp = new HashMap<>();
        int i=0,j=0, max =-1;
        
        while(j<S.length()){
            char endChar = S.charAt(j);
            if(!mp.containsKey(endChar))
            mp.put(endChar, 1);
            else
            mp.put(endChar, mp.get(endChar)+1);
            
            
            if(mp.size()==j-i+1){
            max=Math.max(max, j-i+1);
            j++;
            }
            
           else if(mp.size()<j-i+1)
            {
                while(mp.size()<j-i+1){
                    char startChar=S.charAt(i);
                    
                    if(mp.containsKey(startChar))
                    mp.put(startChar, mp.get(startChar)-1);
                    
                    if(mp.get(startChar)==0)
                    mp.remove(startChar);
                    
                    i++;
                }
                j++;
            }
        }
        return max;
    }
}