// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}// } Driver Code Ends


//User function Template for Java

class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int M)
    {
        //Your code here
        int ans =0;
        int sum =0;
        int min=A[0];
        for(int i =0;i<N;i++){
            sum+=A[i];
            min=Math.min(min,A[i]);
        }
        
        int lo = min;
        int hi = sum;
        
        while(lo<=hi){
            int mid = (lo+hi)/2;
            
            if(allocation(A,N,M,mid)){
                ans =mid;
                hi = mid-1;
            }else
            lo = mid+1;
        }
        return ans;
    }
    
    public static boolean allocation(int[]arr, int books, int stu, int mid){
        int curPage =0, allocatedStu =1;
        for(int i =0;i<books;i++){
            if(arr[i]>mid)
            return false;
            
            if(arr[i]+curPage>mid){
                allocatedStu++;
                curPage = arr[i];
                
                if(allocatedStu>stu)
                return false;
            }else{
                curPage+=arr[i];
            }
        }
        return true;
    }
};