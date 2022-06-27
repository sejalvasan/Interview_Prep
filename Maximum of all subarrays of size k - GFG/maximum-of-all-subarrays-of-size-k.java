// { Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.io.*;
import java.lang.*;

class Main
{
    public static void main(String args[])
    {
        //taking input using class Scanner
        Scanner sc = new Scanner(System.in);
        
        //taking total count of testcases
        int t = sc.nextInt();
        
        
        
        while(t-- > 0)
        {
            //taking total number of elements
            int n = sc.nextInt();
            
            //taking size of subArrays 
            int k = sc.nextInt();
            
            //Declaring and Intializing an array of size n
            int arr[] = new int[n];
            
            //adding all the elements to the array 
            for(int i = 0; i <n; i++)
            {
                arr[i] =sc.nextInt();
            }
            
            //Calling the method max_of_subarrays of class solve
            //and storing the result in an ArrayList
            ArrayList <Integer> res = new Solution().max_of_subarrays(arr, n, k);
            
            //printing the elements of the ArrayList
            for (int i = 0; i < res.size(); i++)
                System.out.print (res.get (i) + " ");
            System.out.println();
        }
    }
}// } Driver Code Ends


//User function template for JAVA

class Solution
{
    //Function to find maximum of each subarray of size k.
    static ArrayList <Integer> max_of_subarrays(int nums[], int n, int k)
    {
        // Your code here
        
        int premax[] = new int[n];
        int sufmax[] = new int[n];
        
        premax[0]=nums[0];
        sufmax[n-1]=nums[n-1];
        
        for(int i=1;i<n;i++){
            if(i%k==0)
                premax[i]=nums[i];
            else
        premax[i]=Math.max(premax[i-1],nums[i]);
        }
        
        for(int i=n-2;i>=0;i--){
            if((i+1)%k==0)
                sufmax[i]=nums[i];
            else
        sufmax[i]=Math.max(sufmax[i+1],nums[i]);
        }
        
       ArrayList<Integer> ans = new ArrayList<>();
        
        ans.add(sufmax[0]);
        
        for(int i=1;i<=n-k;i++){
            ans.add(Math.max(sufmax[i],premax[i+k-1]));
        }
        return ans;
    }
}