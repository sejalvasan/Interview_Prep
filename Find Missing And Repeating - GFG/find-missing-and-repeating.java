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
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int nums[], int n) {
        // code here
        int[]ans = new int[2];
        
        int i=0;
        
        while(i<n){
            if(nums[i]!=i+1){
                int correct = nums[i]-1;
               if(nums[i]==nums[correct]){
                   i++;
                   continue;
               }else{
                   int temp = nums[i];
                   nums[i] = nums[correct];
                   nums[correct] = temp;
                   i--;
               }
            }
            i++;
        }
        
        for(i=0;i<n;i++){
            if(nums[i]!=i+1){
                ans[0] = nums[i];
                ans[1] = i+1;
            }
        }
        
        return ans;
    }
}