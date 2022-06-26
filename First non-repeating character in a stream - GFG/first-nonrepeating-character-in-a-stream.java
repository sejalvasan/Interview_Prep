// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    public String FirstNonRepeating(String A)
    {
        // code here
        String ans ="";
        int []cnt= new int[26];
        Queue<Character> q = new LinkedList<>();
        int n = A.length();
        
        for(int i=0;i<n;i++){
            
            char c = A.charAt(i);
            cnt[c-'a']++;
            
            if(cnt[c-'a']==1)
            q.add(c);
            
            while(!q.isEmpty() && cnt[q.peek()-'a']>1)
             q.remove();
            
             if(q.isEmpty())
                ans+='#';
            
            else
            ans +=q.peek();
        }
        return ans;
    }
}