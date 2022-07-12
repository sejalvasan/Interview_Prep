// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.numberOfWays(N));
        }
    }
}// } Driver Code Ends


class Solution {
    static Long numberOfWays(int N) {
        // code herE
       Long[] fib= new Long[100005];
		fib[1] = 1L;
		fib[2] = 2L;
		for(int i=3 ; i<=N ; i++)
			fib[i] = (fib[i-1]+fib[i-2])%1000000007;
			
		return fib[N];
    }
};