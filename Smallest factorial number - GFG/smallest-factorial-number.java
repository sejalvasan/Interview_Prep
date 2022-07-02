// { Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        
        while (t-- > 0)
        {
            int n = sc.nextInt();
            
            System.out.println(new Solution().findNum(n));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    int findNum(int n)
    {
        // Complete this function
        
             if (n==1)
            return 5;
            
        int low = 0;
        int high = 5 * n;
  //   int ans =0;
        // Binary Search.
        while (low < high)
        {
            int mid = (low + high) >> 1;
     
            // Checking if mid's factorial
            // contains n trailing zeroes.
            if (check(mid, n)){
               // ans = mid;
                high = mid;
            }
            else
                low = mid + 1;
        }
     
        return low;
    }
    public boolean check(int p, int n){
        int count =0;
        int f =5;
        while(p/f>0){
            count+=p/f;
            f=f*5;
        }
        if(count>=n)
        return true;
        
        return false;
    }
}