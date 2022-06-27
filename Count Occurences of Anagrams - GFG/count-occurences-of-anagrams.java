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
            String txt = br.readLine().trim();
            String pat = br.readLine().trim();

            int ans = new Solution().search(pat, txt);

            System.out.println(ans);
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {

    int search(String pat, String txt) {
        // code here
        HashMap<Character, Integer> map = new HashMap<>();
        int k = pat.length();
        int n = txt.length();
        
        for(int i =0;i<k;i++){
            char c = pat.charAt(i);
            if(map.containsKey(c))
            map.put(c,map.get(c)+1);
            else
            map.put(c,1);
        }
        
        int count = map.size();
        
        int i =0, j=0;
        int ans =0;
        
        while(j<n){
            char endChar = txt.charAt(j);
            
            if(map.containsKey(endChar))
            {
                map.put(endChar, map.get(endChar)-1);
            }
            
            if(map.get(endChar)!=null && map.get(endChar)==0)
            count--;
            
            if(j-i+1<k){
                j++;
            }
            else if(j-i+1 == k){
                if(count == 0)
                ans+=1;
                
                char startChar = txt.charAt(i);
                
                if(map.containsKey(startChar)){
                    map.put(startChar,map.get(startChar)+1);
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