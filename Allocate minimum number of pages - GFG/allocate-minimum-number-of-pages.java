//{ Driver Code Starts
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
}
// } Driver Code Ends

class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int m)
    {
        //Your code here
        if(m>N)
        return -1;
        
        int ans =0;
        int sum =0;
        int max=A[0];
        
        for(int i =0;i<N;i++){
            sum+=A[i];
            max=Math.max(max,A[i]);
        }
        
       int low = max;
        int high = sum;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            int students = countStudents(A, mid);
            if (students > m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
    
    public static int countStudents(int arr[], int pages) {
        int n = arr.length; // size of array
        int students = 1;
        long pagesStudent = 0;
        for (int i = 0; i < n; i++) {
            if (pagesStudent + arr[i] <= pages) {
                // add pages to current student
                pagesStudent += arr[i];
            } else {
                // add pages to next student
                students++;
                pagesStudent = arr[i];
            }
        }
        return students;
    }
}