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
        HashMap<Character, Integer> map = new HashMap<>();
        int i=0,j=0, max =-1;
        
        while(j<S.length()){
            char endChar =S.charAt(j);
            
        
            if(!map.containsKey(endChar))
            map.put(endChar,1);
            else{
                map.put(endChar,map.get(endChar)+1);
            }
            
            if(map.size()==j-i+1)
            max=Math.max(max,j-i+1);
            else {
            while(map.size()<j-i+1){
                char startChar = S.charAt(i);
                if(map.containsKey(startChar))
                map.put(startChar,map.get(startChar)-1);
                if(map.get(startChar)==0)
                map.remove(startChar);
                i++;
             }
            }
            j++;
        }
            return max;
        }
    }