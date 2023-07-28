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
            String[] inp=read.readLine().split(" ");
            int S=Integer.parseInt(inp[0]);
            int D=Integer.parseInt(inp[1]);

            Solution ob = new Solution();
            System.out.println(ob.smallestNumber(S,D));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
 class Solution{
    static String smallestNumber(int s, int m){
          if(s==0)
    	{
    		if(m==1) 
    		    return "0";
    		else
    		    return "-1";
    	}
  
        // Sum greater than the maximum possible sum
        if (s > 9*m)
        {
            return "-1";
        }
  
        // Create an array to store digits of result
        int[] res = new int[m];
  
        // deduct sum by one to account for cases later
        // (There must be 1 left for the most significant
        //  digit)
        s -= 1;
  
        // Fill last m-1 digits (from right to left)
        for (int i=m-1; i>0; i--)
        {
            // If sum is still greater than 9,
            // digit must be 9
            if (s > 9)
            {
                res[i] = 9;
                s -= 9;
            }
            else
            {
                res[i] = s;
                s = 0;
            }
        }
  
        // Whatever is left should be the most significant
        // digit
        res[0] = s + 1;  // The initially subtracted 1 is
                        // incorporated here
       String ans= "";
       for(int i=0;i<m;i++){
           ans+=res[i];
       }
       
       return ans;
    }
}