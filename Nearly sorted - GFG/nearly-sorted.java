//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int num = sc.nextInt();
            int k = sc.nextInt();
            
            int arr[] = new int[num];
            for(int i = 0; i < num; i++)
                arr[i] = sc.nextInt();
            
            ArrayList <Integer> res = new Solution().nearlySorted(arr, num, k);
            for (int i = 0; i < res.size (); i++)
                System.out.print (res.get (i) + " ");
            System.out.println();
        }
    }
}


// } Driver Code Ends


class Solution
{
    //Function to return the sorted array.
    ArrayList <Integer> nearlySorted(int arr[], int num, int k)
    {
        // your code here
        ArrayList<Integer> ans = new ArrayList<>();
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i =0;
        while(pq.size()<=k){
            pq.add(arr[i]);
            i++;
         }
         
        for(i =k+1;i<arr.length;i++){
            ans.add(pq.remove());
            pq.add(arr[i]);
        }
        
        while(!pq.isEmpty()){
            ans.add(pq.remove());
        }
        
        return ans;
    }
}
