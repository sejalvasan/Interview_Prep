//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        while(t > 0){
            
            //taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];
            
            //inserting elements in the array
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling longestSubsequence() method of class
            //Solution
            System.out.println(ob.longestSubsequence(n,array));
            t--;
        }
    } 
} 
// } Driver Code Ends




class Solution 
{
    //Function to find length of longest increasing subsequence.
    static int longestSubsequence(int size, int a[])
    {
        // code here
        // int[]dp = new int[size];
        // int omax = 0;
        
        // for(int i=0;i<size;i++){
        //     int max = 0;
            
        //     for(int j=0;j<i;j++){
        //         if(a[i]>a[j] && dp[j]>max)
        //         max = dp[j];
        //     }
            
        //     dp[i]=max+1;
        //     omax = Math.max(omax, dp[i]);
        // }
        
        // return omax;
        
        int lastIndex = 0;
        int tail[] = new int[size];
        tail[0] = a[0];
        
        for(int i=1;i<size;i++){
            int index = bs(tail, 0, lastIndex, a[i]);
            tail[index] = a[i];
            lastIndex = Math.max(lastIndex, index);
        }
        
        return lastIndex+1;
    }
    
    public static int bs(int[]tail, int l, int h, int val){
        if(val>tail[h])
        return h+1;
        
        while(l<h){
            int mid = (h+l)/2;
            
            if(tail[mid]==val)
            return mid;
            
            else if(tail[mid]>val)
            h = mid;
            
            else
            l = mid+1;
        }
        
        return h;
    }
} 