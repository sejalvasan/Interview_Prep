//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 
import java.lang.*;

// } Driver Code Ends
//User function Template for Java

class Info{
	int distance;
	int houseno;

	Info(int x,int y)
	{
		distance = x;
		houseno = y;
	}
}

class Compare implements Comparator<Info>{ 
	public int compare (Info p1,Info p2 )
	{
		if (p1.distance == p2.distance)	{
			if (p1.houseno < p2.houseno)
				return +1;
			if (p1.houseno > p2.houseno)
				return -1;
			return 0;
		}

		else {
		   	if (p1.distance < p2.distance)
				return +1;
			if (p1.distance > p2.distance)
				return -1;
			return 0;
		}
	}
}

class Solution 
{ 
	public  ArrayList<Integer> Kclosest(int arr[], int n, int x, int k) 
	{ 
		ArrayList<Integer> result= new ArrayList<Integer>();
		PriorityQueue<Info> pq = new PriorityQueue<Info>(k, new Compare()); 

		for (int i = 0; i < n; i++) 
		{ 
		
			Info obj = new Info(Math.abs(arr[i] - x) , arr[i] );
			pq.add(obj);
			if(pq.size()>k){
			    pq.remove();
			}
		} 
		
		while (pq.size() >0) { 
			result.add(pq.peek().houseno);
			pq.remove();
		}
		Collections.sort(result);
		return result;
	}    
} 

//{ Driver Code Starts.
class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
        	int n = sc.nextInt();
        	int x = sc.nextInt();
        	int k = sc.nextInt();
        	int arr[] = new int[n];
        	for(int i=0; i<n; i++)
        	{
        		arr[i] = sc.nextInt();
        	}
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.Kclosest(arr,n,x,k);

            for (int i=0; i<ans.size(); i++) 
        	    System.out.print(ans.get(i)+" "); 
            System.out.println();
            t--;
        }
    } 
} 




// } Driver Code Ends