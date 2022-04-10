// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            int M = Integer.parseInt(S[0]);
            int N = Integer.parseInt(S[1]);
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.primeRange(M, N);
            for (int i : ans) System.out.print(i + " ");
            System.out.println();
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    ArrayList<Integer> primeRange(int M, int N) {
        // code here
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i =M;i<=N;i++){
            if(isPrime(i)==true)
            ans.add(i);
        }
        return ans;
    }
    
    public static boolean isPrime(int a){
        if(a==0||a==1)
        return false;
        
        for(int i=2;i*i<=a;i++){
            if(a%i==0)
            return false;
        }
        return true;
    }
}