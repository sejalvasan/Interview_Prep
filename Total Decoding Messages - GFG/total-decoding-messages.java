// { Driver Code Starts
//Initial Template for Java

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
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.CountWays(str);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int CountWays(String str)
    {
        // code here
        int mod = 1000000007;
        if(str.charAt(0) =='0')
        return 0;
        
        int[]dp = new int[str.length()];
        dp[0]=1;  //single char has 1 encoding
        
        for(int i =1;i<dp.length;i++){
            if(str.charAt(i-1)=='0' && str.charAt(i)=='0'){
                dp[i]=0;
            }
            else if(str.charAt(i-1)=='0' && str.charAt(i)!='0'){
                dp[i]=dp[i-1]%mod;
            }
            else if(str.charAt(i-1)!='0' && str.charAt(i)=='0'){
                if(str.charAt(i-1)=='1' || str.charAt(i-1)=='2')
                dp[i]= (i>=2?dp[i-2]:1)%mod;
                else
                dp[i]=0;
            }
            else{
                if(Integer.parseInt(str.substring(i-1,i+1))<=26){
                    dp[i] = ((i>=2?dp[i-2]:1) +dp[i-1])%mod;
                }else{
                    dp[i]=dp[i-1]%mod;
                }
            }
        }
        return dp[str.length()-1]%mod;
    }
}