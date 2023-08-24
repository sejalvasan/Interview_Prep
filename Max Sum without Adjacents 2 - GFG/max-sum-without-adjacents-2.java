//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMaxSum(arr, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    int findMaxSum(int arr[], int n) {
        // code here
   int sum[] = new int[n];
 
        // Base cases (process first three elements)
        if (n >= 1)
            sum[0] = arr[0];
 
        if (n >= 2)
            sum[1] = arr[0] + arr[1];
 
        if (n > 2)
            sum[2] = Math.max(sum[1], Math.max(arr[1] + arr[2], arr[0] + arr[2]));
 
        // Process rest of the elements
        // We have three cases
        // 1) Exclude arr[i], i.e., sum[i] = sum[i-1]
        // 2) Exclude arr[i-1], i.e., sum[i] = sum[i-2] + arr[i]
        // 3) Exclude arr[i-2], i.e., sum[i-3] + arr[i] + arr[i-1]
        for (int i = 3; i < n; i++)
            sum[i] = Math.max(Math.max(sum[i - 1], sum[i - 2] + arr[i]),
                              arr[i] + arr[i - 1] + sum[i - 3]);
 
        return sum[n - 1];
    }
}