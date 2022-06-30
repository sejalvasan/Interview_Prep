// { Driver Code Starts
//Initial Template for Java

import java.util.*;
class KthSmallestElement{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=Integer.parseInt(sc.next());
		while(t>0)
		{
			int n=Integer.parseInt(sc.next());
			int[][] a=new int[n][n];
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
    				a[i][j]=Integer.parseInt(sc.next());
    		
			int k=Integer.parseInt(sc.next());
		    Solution ob = new Solution();
		    System.out.println(ob.kthSmallest(a,n,k));
		    
		    t--;
		}
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
	public static int kthSmallest(int[][]arr,int n,int k)
	{
      int startVal = arr[0][0];
    int endVal = arr[n-1][n-1];
    
    while(startVal<=endVal){
    int midVal = (startVal+endVal)/2;
  int ans =0;
  for(int i =0;i<n;i++){  
      
    int lo =0;
    int hi = arr[0].length-1;
    
    while(lo<=hi){
       int mid =lo+(hi-lo)/2;
       if(arr[i][mid]<=midVal){
           lo =mid+1; 
       }else{
           hi = mid-1;
       }
    }
   ans+=lo;
    }
        if(ans<k){
            startVal = midVal+1;
        }else{
            endVal=midVal-1;
        }
    }
    return startVal;
    }
}
     