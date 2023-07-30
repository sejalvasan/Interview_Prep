//{ Driver Code Starts
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
            String txt = br.readLine().trim();
            String pat = br.readLine().trim();

            int ans = new Solution().search(pat, txt);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int search(String pat, String txt) {
        // code here
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i=0;i<pat.length();i++){
            char s = pat.charAt(i);
            map.put(s, map.getOrDefault(s,0)+1);
        }
        
        int count = map.size();
        int k = pat.length();
        int ans = 0;
        
        int i=0, j=0;
        
        while(j<txt.length()){
            char endChar = txt.charAt(j);
            
            if(map.containsKey(endChar)){
                map.put(endChar, map.get(endChar)-1);
            }
            
            if(map.get(endChar)!=null && map.get(endChar)==0)
            count--;
            
            if(j-i+1<k)
            j++;
            
            else if(j-i+1==k){
                char startChar = txt.charAt(i);
                
                if(count==0)
                ans+=1;
                
                if(map.containsKey(startChar)){
                    map.put(startChar, map.get(startChar)+1);
                }
                
                if(map.get(startChar)!=null && map.get(startChar)==1)
                count++;
                
                i++;
                j++;
            }
        }
        
        return ans;
    }
}