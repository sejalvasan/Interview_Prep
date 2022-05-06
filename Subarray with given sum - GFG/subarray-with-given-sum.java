// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main{
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int s = sc.nextInt();

            int[] m = new int[n];
            for (int j = 0; j < n; j++) {
                m[j] = sc.nextInt();
            }
            
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.subarraySum(m, n, s);
            for(int ii = 0;ii<res.size();ii++)
                System.out.print(res.get(ii) + " ");
            System.out.println();
        }
    }

}// } Driver Code Ends


class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        // Your code here
        ArrayList<Integer> ans = new ArrayList<>();
        int start=0;int end=0;int sum=0; boolean flag=false;
     
     for(int i=0;i<n;i++){
         sum+=arr[i];
         
         if(sum>=s){
             end=i;
             
             while(sum>s && start<end){
                 sum-=arr[start];
                 start++;
             }
             
             if(sum==s){
                 ans.add(start+1);
                 ans.add(end+1);
                 
                 flag=true;
                 break;
             }
         }
     }
     
     if(flag==false){
         ans.add(-1);
     }
     return ans;
    }
}